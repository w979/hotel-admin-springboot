package com.sevenhome.service.impl;

import com.sevenhome.bean.fo.CheckOutFo;
import com.sevenhome.bean.po.Business;
import com.sevenhome.bean.po.DepositDetail;
import com.sevenhome.bean.po.Employee;
import com.sevenhome.bean.po.Orders;
import com.sevenhome.bean.vo.EmployeeVo;
import com.sevenhome.dao.*;
import com.sevenhome.service.ICheckOutService;
import com.sevenhome.utils.ResponseResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
@Service
@Transactional
public class CheckOutService implements ICheckOutService {
    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private RoomDao roomDao;
    @Resource
    private OrdersDao ordersDao;
    @Resource
    private CheckInDao checkInDao;
    @Resource
    private RoomStatusDao roomStatusDao;
    @Resource
    private BusinessDao businessDao;
    @Resource
    private DepositDetailDao depositDetailDao;
    @Resource
    private DepositDao depositDao;
    @Override
    public List<String> getCancelSectionDates(CheckOutFo checkOutFo) {
        Employee emp = employeeDao.findEmployeeByUserName(checkOutFo.getUsername());
        Integer roomId = roomDao.getRoomId(checkOutFo.getRoomno(), emp.getHotelId());
        String orderNoByRoomId = ordersDao.getOrderNoByRoomId(roomId);

        List<String> Interval_days = new ArrayList<>();

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatNow = sdf.format(now);
        String[] s = formatNow.split(" ");

        String[] split = s[1].split(":");
        Integer now_hour = Integer.valueOf(split[0]);
        //模拟离店时间
        Orders orders = ordersDao.selectOrdersByOrdersno(orderNoByRoomId);
        Date checkinLeavetime = orders.getCheckIn().getCheckinLeavetime();
        //如果退房时间大于当前时间直接返回
        if (checkinLeavetime.getTime()<=now.getTime()){
            return Interval_days;
        }
        String outHotelTime = sdf.format(checkinLeavetime);
        System.out.println(outHotelTime);
        String[] s1 = outHotelTime.split(" ");
        Date parse = null;
        try {
            parse = sdf.parse(outHotelTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //计算间隔天数
        long days = (parse.getTime()- now.getTime())/1000/60/60/24;

        if(now_hour < 12){
            Interval_days.add(s[0]);
        }

        for (int i = 0; i < days ;i++){
            long putDay = now.getTime()+24*60*60*1000;
            now = new Date(putDay);
            String format = sdf.format(now);
            String[] s2 = format.split(" ");
            Interval_days.add(s2[0]);
        }
        if (Interval_days.get(Interval_days.size()-1).equals(s1[0])){
            Interval_days.remove(Interval_days.size()-1);
        }
        return Interval_days;
    }

    @Override
    public HashMap<String, String> cancelSection(CheckOutFo checkOutFo) {
        Employee emp = employeeDao.findEmployeeByUserName(checkOutFo.getUsername());
        Integer roomId = roomDao.getRoomId(checkOutFo.getRoomno(), emp.getHotelId());
        String orderno = ordersDao.getOrderNoByRoomId(roomId);
        Orders orders = ordersDao.selectOrdersByOrdersno(orderno);

        Date checkinLeavetime = orders.getCheckIn().getCheckinLeavetime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = checkOutFo.getUpdateLeaveTime()+" 14:00:00";
        //修改的日期
        Date newLeaveTime = null;
        try {
            newLeaveTime = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long interval = checkinLeavetime.getTime() - newLeaveTime.getTime();
        //到店时间
        Date checkinIntime = orders.getCheckIn().getCheckinIntime();
        String format = sdf.format(checkinIntime);
        String[] s = format.split(" ");
        String inTime = s[0]+" 14:00:00";
        Date parse = null;
        try {
            parse = sdf.parse(inTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //原 离店时间 - 到店时间 = 原预定天数
        long l = checkinLeavetime.getTime() - parse.getTime();
        long oldDays = l / 24 / 60 / 60 / 1000;
        //退掉的天数
        long days = interval / 24 / 60 / 60 / 1000;

        //原价格
        BigDecimal orderTotalprice = orders.getCheckIn().getCheckinRoomrate();

        //单日价格
        BigDecimal oneDayPrice = orderTotalprice.divide(BigDecimal.valueOf(oldDays), BigDecimal.ROUND_HALF_UP).setScale(1, BigDecimal.ROUND_HALF_UP) ;
        //退给客户的钱
        BigDecimal refund = oneDayPrice.multiply(BigDecimal.valueOf(days));

        //按比例修改订单金额（订单表），修改预约中的离店时间（预约表），修改登记中的离店时间（登记表）
        orders.setOrderTotalprice(orderTotalprice.subtract(refund));
        //修改订单
        ordersDao.updateByPrimaryKeySelective(orders);
        //修改登记
        checkInDao.updateLeaveTime(orders.getCheckIn().getId(),newLeaveTime,orders.getCheckIn().getCheckinRoomrate().subtract(refund));
        //删除房态
        roomStatusDao.delRoomStatusByDateAndRoomId(newLeaveTime, roomId);

        HashMap<String, String> map = new HashMap<>();
        map.put("returnDays",String.valueOf(days));
        map.put("returnMoney",String.valueOf(refund));
        return map;
    }

    @Override
    public HashMap<String, Object> checkOutRightNow(CheckOutFo checkOutFo) {
        Employee emp = employeeDao.findEmployeeByUserName(checkOutFo.getUsername());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //需退给客户的房费
        BigDecimal refund = new BigDecimal(0);
        //当前时间
        Date now = new Date();
        //退房房间的主键
        Integer roomId = roomDao.getRoomId(checkOutFo.getRoomno(), emp.getHotelId());
        //当前订单编号
        String orderno = ordersDao.getOrderNoByRoomId(roomId);
        //当前订单
        Orders orders = ordersDao.selectOrdersByOrdersno(orderno);
        //根据订单查到登记的离店时间
        Date oldcheckinLeavetime = orders.getCheckIn().getCheckinLeavetime();
        //预计离店时间日期字符串
        String[] s2 = sdf.format(oldcheckinLeavetime).split(" ");
        //今日日期
        String format = sdf.format(now);
        String[] s = format.split(" ");
        String todayLeave = s[0]+ " 14:00:00";
        Date todayLeaveDate = null;
        try {
            todayLeaveDate = sdf.parse(todayLeave);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //剩余天数
        long days = (oldcheckinLeavetime.getTime()-todayLeaveDate.getTime())/24/60/60/1000;
        //预计到店时间
        Date checkinIntime = orders.getCheckIn().getCheckinIntime();
        String format1 = sdf.format(checkinIntime);
        String[] s1 = format1.split(" ");
        String inTime = s1[0]+" 14:00:00";
        Date parse = null;
        try {
            parse = sdf.parse(inTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //原 离店时间 - 到店时间 = 原预定天数
        long l = oldcheckinLeavetime.getTime() - parse.getTime();
        long oldDays = l / 24 / 60 / 60 / 1000;
        //单日价格
        BigDecimal orderTotalprice = orders.getCheckIn().getCheckinRoomrate();
        BigDecimal oneDayPrice = orderTotalprice.divide(BigDecimal.valueOf(oldDays), BigDecimal.ROUND_HALF_UP).setScale(1, BigDecimal.ROUND_HALF_UP);
        if (days == 0){
            //无多余住房时间

        }else {
            String todayNoon = s[0]+" 12:00:00";
            Date todayNoonDate = null;
            try {
                todayNoonDate = sdf.parse(todayNoon);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //当前时间是12点前还是12点后
            if (now.getTime()-todayNoonDate.getTime()>0){
                //12点后
                days = days - 1;
            }
        }
        //删除当天房态即之后的房态
        String startDateString = s[0]+" 00:00:00";
        String endDateString = s2[0]+" 00:00:00";
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse(startDateString);
            endDate = sdf.parse(endDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(startDate);
        System.out.println(endDate);
        roomStatusDao.delRoomStatusByNewLeaveDateAndOldLeaveDate(startDate,endDate,roomId);
        //返回该订单的押金列表
        Integer depositIdByOrderid = depositDao.getDepositIdByOrderid(orders.getId());
        List<DepositDetail> depositDetailListByOrderid = depositDetailDao.queryAllDepositDetail(depositIdByOrderid);
        //返回剩余房费
        refund = oneDayPrice.multiply(BigDecimal.valueOf(days));
        //修改订单状态为完成
        orders.setOrderTotalprice(orders.getOrderTotalprice().subtract(refund));
        orders.setOrderStatus("1");
        ordersDao.updateByPrimaryKeySelective(orders);
        HashMap<String, Object> map = new HashMap<>();
        //修改预约
        //subscribeService.updateLeaveTime(orders.getSubscribe().getId(),now,orders.getSubscribe().getSubscribeRoomrate().subtract(refund));
        //修改登记
        checkInDao.updateLeaveTime(orders.getCheckIn().getId(),now,orders.getCheckIn().getCheckinRoomrate().subtract(refund));
        //修改房间状态为脏
        roomDao.updateRoomStatusToDirty(roomId);
        //添加客房部清房事务
        Business business = new Business();
        business.setGrorderId(orders.getId());
        businessDao.insertSelective(business);
        //返回结果
        map.put("returnDays",String.valueOf(days));
        map.put("returnMoney",String.valueOf(refund));
        map.put("depositDetailList",depositDetailListByOrderid);
        return map;
    }
}
