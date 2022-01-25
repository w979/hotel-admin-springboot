package com.sevenhome.service;

import java.math.BigDecimal;
import com.sevenhome.bean.fo.CheckinFo;

import java.util.Date;
import java.util.List;

public interface ICheckInService {

    int updateLeaveTime(Integer id,Date leaveTime, BigDecimal money);

    List<Integer> getCheckinIdByLeaveTime(Date leaveTime);

    /**
     * 向登记表插入数据
     * @param checkinFo
     * @return
     */
    int insertCheckin(CheckinFo checkinFo) throws Exception;

    /**
     * 支付完成后插入支付方式
     * @param payType
     * @param id
     * @return
     */
    int updatePayType(Integer payType,Integer id);

    /**
     * 计算总金额并返回
     * @param beginTime
     * @param endTime
     * @param deposit
     * @param roomrate
     * @return
     */
    String getTotal(String beginTime,String endTime,String deposit,String roomrate,String vipNo) throws Exception;
}
