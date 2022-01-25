package com.sevenhome.service.impl;

import com.sevenhome.bean.fo.SubscribeFo;
import com.sevenhome.bean.po.*;
import com.sevenhome.dao.*;
import com.sevenhome.bean.po.CheckIn;
import com.sevenhome.bean.po.Orders;
import com.sevenhome.bean.vo.CheckOutRoomVo;
import com.sevenhome.dao.CheckInDao;
import com.sevenhome.dao.OrdersDao;
import com.sevenhome.service.IOrdersService;
import com.sevenhome.utils.RandomCode;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sevenhome.bean.po.Orders;
import com.sevenhome.bean.vo.OrdersVo;
import com.sevenhome.dao.OrdersDao;
import com.sevenhome.service.IOrdersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 何好
 */
@Service
@Transactional
public class OrdersService implements IOrdersService {
    @Resource
    private OrdersDao ordersDao;
    @Resource
    private RoomDao roomDao;
    @Resource
    private RoomStatusDao roomStatusDao;
    @Resource
    private EmployeeDao employeeDao;
    @Resource
    private SubscribeDao subscribeDao;


    /**
     * 获得从现在到退房前一天的日期
     * hh
     * @param orderno
     * @return
     */
    @Override
    public List<String> outHotelTimeList(String orderno) {
        List<String> Interval_days = new ArrayList<>();

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatNow = sdf.format(now);
        String[] s = formatNow.split(" ");

        String[] split = s[1].split(":");
        Integer now_hour = Integer.valueOf(split[0]);
        //模拟离店时间
        Orders orders = ordersDao.selectOrdersByOrdersno(orderno);
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

    /**
     * 根据房间主键获得订单编号
     * hh
     * @param roomid
     * @return
     */
    @Override
    public String getOrderNoByRoomId(Integer roomid) {
        return ordersDao.getOrderNoByRoomId(roomid);
    }

    /**
     * 根据房间编号获得订单
     * hh
     * @param orderno
     * @return
     */
    @Override
    public Orders getOrdersByOrderNo(String orderno) {
        return ordersDao.selectOrdersByOrdersno(orderno);
    }

    /**
     * 更新订单价格
     * hh
     * @param orders
     * @return
     */
    @Override
    public int updateOrders(Orders orders) {
        return ordersDao.updateByPrimaryKeySelective(orders);
    }

    /**
     * 修改订单状态
     * wry
     * @param id
     * @param status
     * @return
     */
    @Override
    public int updateOrdersStatus(Integer id, String status) {
        return ordersDao.updateOrdersStatus(id, status);
    }

    /**
    * 查询所有订单信息+条件查询-线上
    * @author wry
    * @date 2022/1/17 14:56
    */
    @Override
    public PageInfo<OrdersVo> QueryAllOrders(Integer pageNo, Integer pageSize,String name,String orderno,String status,Integer hotelid) {
        PageHelper.startPage(pageNo, pageSize);
        //po转vo
        List<OrdersVo> ordersVoList = new ArrayList<>();
        List<Orders> ordersList = ordersDao.queryOrders(name,orderno,status,hotelid);
        PageInfo<Orders> pageInfoOrders = new PageInfo<>(ordersList);
        for (Orders orders : ordersList) {
            OrdersVo ordersVo = new OrdersVo();
            ordersVo.setSubscibeName(orders.getSubscribe().getSubscribeName());
            ordersVo.setOrderno(orders.getOrderno());
            ordersVo.setPhone(orders.getSubscribe().getSubscribePhone());
            ordersVo.setRoomno(orders.getRoom().getRommno());
            ordersVo.setNewtime(new Date());
            ordersVo.setIntime(orders.getSubscribe().getSubscribeIntime());
            ordersVo.setLeavetime(orders.getSubscribe().getSubscribeLeavetime());
            ordersVo.setRoomrate(orders.getOrderTotalprice());
            ordersVo.setOrigin(orders.getSubscribe().getSubscribeOrigin());
            ordersVo.setHotelid(orders.getRoom().getHotel().getId());
            ordersVo.setHotelname(orders.getRoom().getHotel().getHotelName());
            ordersVo.setStatus(orders.getOrderStatus()); //订单状态
            ordersVo.setId(orders.getId());
            ordersVoList.add(ordersVo);
        }
        PageInfo<OrdersVo> pageInfoOrdersVo = new PageInfo<>(ordersVoList);
        //将 po中的分页对象转为 vo 中的分页对象
        pageInfoOrdersVo.setPageNum(pageInfoOrders.getPageNum());
        pageInfoOrdersVo.setPageSize(pageInfoOrders.getPageSize());
        pageInfoOrdersVo.setPages(pageInfoOrders.getPages());
        pageInfoOrdersVo.setTotal(pageInfoOrders.getTotal());
        return pageInfoOrdersVo;
    }

    /**
     * 插入订单表数据
     * @param subscribeFo
     * @return
     */
    @Override
    public int insertOrder(SubscribeFo subscribeFo) throws Exception {

        //将subscribeFo对象转为subscribe对象
        Subscribe subscribe = new Subscribe();
        BeanUtils.copyProperties(subscribeFo, subscribe);
        //向预订表插入记录
        subscribeDao.insertSelective(subscribe);

        //根据id获得当前员工信息（获得操作人所在酒店id）
        List<Employee> employeeList = employeeDao.getEmployee(subscribe.getEmployeeId());
        Employee employee = employeeList.get(0);
        //根据订房与退房时间查询房态信息
        List<RoomStatus> roomStatusList = roomStatusDao.getRoomStatusByTime(subscribe.getSubscribeIntime(), subscribe.getSubscribeLeavetime());
        //将在预订时间期间的所有房态表的房间id存到集合
        List<Integer> ids = new ArrayList<>();
        for(RoomStatus roomStatus:roomStatusList){
            ids.add(roomStatus.getRoomId());
        }

        //查询房态表，获得在该酒店，且在预订房型，且为空的房间对象
        Room roomType = roomDao.getRoomGroupBy(employee.getHotelId(), subscribe.getRoomtypeId(), ids);

        Room roomId = roomDao.getOneRoomId(roomType.getRoomtypeId(), ids);

        Orders orders = new Orders();
        orders.setOrderno(RandomCode.getNo());
        Subscribe getTotal = subscribeDao.getSubscribeByName(subscribe.getSubscribeName(),subscribe.getId());
        BigDecimal totalPrice = getTotal.getSubscribeDeposit().add(getTotal.getSubscribeRoomrate());
        orders.setSubscribeId(subscribe.getId());
        orders.setOrderTotalprice(totalPrice);
        orders.setOrderStatus("3");
        orders.setOrderGeneratetime(new Date());
        orders.setRoomId(roomId.getId());

         //预订后向房态表插入记录
        Date intime = subscribeFo.getSubscribeIntime();
        Long leavetime = subscribeFo.getSubscribeLeavetime().getTime()-24*60*60*1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date finalLeaveTime = new Date(leavetime);
        String formatIntime = sdf.format(intime);
        String formatLeavetime = sdf.format(finalLeaveTime);
        List<RoomStatus> statusList = roomStatusDao.findRoomStatus(roomId.getId(), formatIntime, formatLeavetime);
        List<Integer> roomIds = new ArrayList<>();
        for(RoomStatus roomStatus:statusList){
            roomIds.add(roomStatus.getId());
        }
        if(roomIds!=null){
            roomStatusDao.updateRoomStatus(roomIds);
        }else {
            throw new Exception("没有该房间！");
        }

        return ordersDao.insertSelective(orders);
    }

    @Override
    public List<Integer> getRoomidByCheckinId(List<Integer> checkinIds) {
        return ordersDao.getRoomidByCheckinId(checkinIds);
    }

    @Override
    public PageInfo<CheckOutRoomVo> getLeaveRoomList(Integer hotelid, String roomno, Integer pageno) {
        PageHelper.startPage(pageno,10);
        List<Orders> leaveRoomList = ordersDao.getLeaveRoomList(hotelid, roomno);
        System.out.println(leaveRoomList);
        PageInfo<Orders> ordersPageInfo = new PageInfo<>(leaveRoomList);

        ArrayList<CheckOutRoomVo> list = new ArrayList<>();
        for (Orders orders : ordersPageInfo.getList()) {
            CheckOutRoomVo checkOutRoomVo = new CheckOutRoomVo();
            checkOutRoomVo.setRoomno(orders.getRoom().getRommno());
            checkOutRoomVo.setCheckinIdCard(orders.getCheckIn().getCheckinIdcard());
            checkOutRoomVo.setRoomid(orders.getRoom().getId());
            checkOutRoomVo.setDeposit(orders.getCheckIn().getCheckinDeposit());
            checkOutRoomVo.setCheckinName(orders.getCheckIn().getCheckinName());
            checkOutRoomVo.setCheckinPhone(orders.getCheckIn().getCkeckinPhone());
            checkOutRoomVo.setRoomrate(orders.getCheckIn().getCheckinRoomrate());
            list.add(checkOutRoomVo);
        }
        PageInfo<CheckOutRoomVo> checkOutRoomVoPageInfo = new PageInfo<>();
        checkOutRoomVoPageInfo.setPageNum(ordersPageInfo.getPageNum());
        checkOutRoomVoPageInfo.setPages(ordersPageInfo.getPages());
        checkOutRoomVoPageInfo.setTotal(ordersPageInfo.getTotal());
        checkOutRoomVoPageInfo.setPageSize(ordersPageInfo.getPageSize());
        checkOutRoomVoPageInfo.setList(list);
        System.out.println(checkOutRoomVoPageInfo);
        return checkOutRoomVoPageInfo;
    }

    /**
     * 订单列表-线下
     * @param pageNo
     * @param pageSize
     * @param name
     * @param orderno
     * @param status
     * @param hotelid
     * @return
     */
    @Override
    public PageInfo<OrdersVo> QueryAllOrdersReality(Integer pageNo, Integer pageSize, String name, String orderno, String status, Integer hotelid) {
        PageHelper.startPage(pageNo, pageSize);
        //po转vo
        List<OrdersVo> ordersVoList = new ArrayList<>();
        List<Orders> ordersList = ordersDao.queryOrdersReality(name,orderno,status,hotelid);
        PageInfo<Orders> pageInfoOrders = new PageInfo<>(ordersList);
        for (Orders orders : ordersList) {
            OrdersVo ordersVo = new OrdersVo();
            ordersVo.setSubscibeName(orders.getCheckIn().getCheckinName());
            ordersVo.setOrderno(orders.getOrderno());
            ordersVo.setPhone(orders.getCheckIn().getCkeckinPhone());
            ordersVo.setRoomno(orders.getRoom().getRommno());
            ordersVo.setNewtime(new Date());
            ordersVo.setIntime(orders.getCheckIn().getCheckinIntime());
            ordersVo.setLeavetime(orders.getCheckIn().getCheckinLeavetime());
            ordersVo.setRoomrate(orders.getOrderTotalprice());
            ordersVo.setOrigin(new Integer(orders.getCheckIn().getCheckinOrigin()));
            ordersVo.setHotelid(orders.getRoom().getHotel().getId());
            ordersVo.setHotelname(orders.getRoom().getHotel().getHotelName());
            ordersVo.setStatus(orders.getOrderStatus()); //订单状态
            ordersVo.setId(orders.getId());
            ordersVoList.add(ordersVo);
        }
        PageInfo<OrdersVo> pageInfoOrdersVo = new PageInfo<>(ordersVoList);
        //将 po中的分页对象转为 vo 中的分页对象
        pageInfoOrdersVo.setPageNum(pageInfoOrders.getPageNum());
        pageInfoOrdersVo.setPageSize(pageInfoOrders.getPageSize());
        pageInfoOrdersVo.setPages(pageInfoOrders.getPages());
        pageInfoOrdersVo.setTotal(pageInfoOrders.getTotal());
        return pageInfoOrdersVo;
    }

}
