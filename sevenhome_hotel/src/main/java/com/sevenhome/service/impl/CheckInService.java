package com.sevenhome.service.impl;

import com.sevenhome.bean.fo.CheckinFo;
import com.sevenhome.bean.po.*;
import com.sevenhome.dao.*;
import com.sevenhome.service.ICheckInService;
import com.sevenhome.utils.RandomCode;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 何好
 */
@Service
@Transactional
public class CheckInService implements ICheckInService {
    @Resource
    private CheckInDao checkInDao;
    @Resource
    private RoomStatusDao roomStatusDao;
    @Resource
    private RoomDao roomDao;
    @Resource
    private VipDao vipDao;
    @Resource
    private OrdersDao ordersDao;
    @Resource
    private UserOnlineDao userOnlineDao;
    @Resource
    private VipTypeDao vipTypeDao;
    @Resource
    private DepositDao depositDao;
    @Resource
    private DepositDetailDao depositDetailDao;


    /**
     * 更新登记表离店时间
     * @param id
     * @param leaveTime
     * @return
     */
    @Override
    public int updateLeaveTime(Integer id,Date leaveTime, BigDecimal money) {
        System.out.println(leaveTime);
        return checkInDao.updateLeaveTime(id,leaveTime,money);
    }

    @Override
    public List<Integer> getCheckinIdByLeaveTime(Date leaveTime) {
        return checkInDao.getCheckinIdByLeaveTime(leaveTime);
    }


    /**
     * 向登记表插入数据
     * @param checkinFo
     * @return
     */
    @Override
    public int insertCheckin(CheckinFo checkinFo) throws Exception {
        CheckIn checkIn = new CheckIn();
        BeanUtils.copyProperties(checkinFo, checkIn);
        if(checkinFo.getVipNo()!=null &&!"".equals(checkinFo.getVipNo())){
            Vip vip = vipDao.getVipByVipNo(checkinFo.getVipNo());
            checkIn.setVipId(vip.getId());
        }
        Room room = roomDao.getRoomFromCheckin(checkinFo.getRoomId());
        checkIn.setRoomId(room.getId());
        checkIn.setCheckinPaytype(null);
        int n = checkInDao.insertSelective(checkIn);
        if(n>0) {
            //登记后向房态表插入记录
            Date intime = checkinFo.getCheckinIntime();
            Long leavetime = checkinFo.getCheckinLeavetime().getTime()-24*60*60*1000;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date finalLeaveTime = new Date(leavetime);
            String formatIntime = sdf.format(intime);
            String formatLeavetime = sdf.format(finalLeaveTime);
            List<RoomStatus> roomStatusList = roomStatusDao.findRoomStatus(room.getId(), formatIntime, formatLeavetime);
            List<Integer> ids = new ArrayList<>();
            for(RoomStatus roomStatus:roomStatusList){
                ids.add(roomStatus.getId());
            }
            if(ids!=null){
                int i = roomStatusDao.updateRoomStatus(ids);
                System.out.println("修改房态表记录数为："+i);
            }else {
                throw new Exception("没有该房间！");
            }


            //登记后向订单表插入记录
            Orders orders = new Orders();
            orders.setOrderno(RandomCode.getNo());
            System.out.println(checkIn.toString());
            orders.setCheckinId(checkIn.getId());
            if(checkinFo.getSubscribeId()!=null && !"".equals(checkinFo.getSubscribeId())){
                orders.setSubscribeId(checkinFo.getSubscribeId());
            }
            orders.setOrderStatus("4");
            BigDecimal total = checkIn.getCheckinDeposit().add(checkIn.getCheckinRoomrate());
            orders.setOrderTotalprice(total);
            orders.setOrderGeneratetime(new Date());
            orders.setRoomId(room.getId());
            ordersDao.insertSelective(orders);

            //登记后向押金表插入记录
            Deposit deposit = new Deposit();
            deposit.setDepositTotal(checkinFo.getCheckinDeposit());
            deposit.setRoomgoodsTotal(new BigDecimal(0));
            deposit.setDepositReturnmoney(checkinFo.getCheckinDeposit());
            deposit.setOrderId(orders.getId());
            deposit.setStatus("n");
            depositDao.insertSelective(deposit);

            //登记后修改用户的累计消费
            if(checkinFo.getVipNo()!=null &&!"".equals(checkinFo.getVipNo())){
                Vip vip = vipDao.UpdateTotalPay(checkinFo.getVipNo());
                userOnlineDao.updateTotalPay(vip.getUserOnline().getUseronlineTotalpay().add(checkinFo.getCheckinRoomrate()), vip.getUserOnline().getId());
            }
        }
        return checkIn.getId();
    }

    /**
     * 支付完成后插入支付方式
     * @param payType
     * @param id
     * @return
     */
    @Override
    public int updatePayType(Integer payType, Integer id) {
        return checkInDao.updatePayType(payType, id);
    }

    /**
     * 登记入住页面计算总金额
     * @param beginTime
     * @param endTime
     * @param deposit
     * @param roomrate
     * @param vipNo
     * @return
     */
    @Override
    public String getTotal(String beginTime, String endTime, String deposit, String roomrate,String vipNo) throws Exception {
        String discount;
        if(vipNo!=null&&!"".equals(vipNo)){
            VipType vipType = vipTypeDao.getVipType(vipDao.getVipByVipNo(vipNo).getViptypeId());
            discount=vipType.getViptypeDiscount();
        }else {
            throw new Exception("没有该vip!");
        }
            discount = "1";
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        try {

            Date dateBegin = sdf.parse(beginTime);
            Date dateEnd = sdf.parse(endTime);

            long result = 0;
            if((dateEnd.getTime()-dateBegin.getTime())/(60*60*1000)<24){
                result = 1;
            } else if((dateEnd.getTime()-dateBegin.getTime())/(60*60*1000)%24>0){
                result = (dateEnd.getTime() - dateBegin.getTime()) / (24* 60 * 60 * 1000)+1;
            } else {
                result = (dateEnd.getTime() - dateBegin.getTime()) / (24* 60 * 60 * 1000);
            }
            System.out.println(result);
            Integer finalPay = Integer.parseInt(roomrate);
            Double finalDiscount = Double.parseDouble(discount);
            Double total = Double.parseDouble(deposit)+finalPay*finalDiscount*result;
            String totalPay = String.valueOf(total);
            return totalPay;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
