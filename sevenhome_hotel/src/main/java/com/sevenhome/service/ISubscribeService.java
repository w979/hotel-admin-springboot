package com.sevenhome.service;

import com.sevenhome.bean.fo.SubscribeFo;
import com.sevenhome.bean.po.Subscribe;
import com.sevenhome.bean.po.Vip;
import com.sevenhome.bean.vo.SubscribeDetailVo;
import com.sevenhome.bean.vo.SubscribeVoPageInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * fzw ISubscribeService
 */
public interface ISubscribeService {

//    /**
//     * 添加预定表信息
//     * @param subscribeFo
//     * @return
//     */
//    int insertSubscribe(SubscribeFo subscribeFo);

    /**
     * 根据条件查询预订列表
     * @param subscribeName
     * @param subscribePhone
     * @param roomtypeId
     * @return
     */
    SubscribeVoPageInfo getListByCondition(
            Integer pageNum,
            Integer pageSize,
            String subscribeName,
            String subscribePhone,
            Integer roomtypeId,
            Integer hotelId);

    int updateLeaveTime(Integer id,Date leaveTime, BigDecimal money);

    /**
     * 根据id修改预约表状态为已取消
     * @param id
     * @return
     */
    int updateSubscribeStatus(Integer id);

    /**
     * 根据id查询预订详情
     * @param id
     * @return
     */
    SubscribeDetailVo getSubscribeById(Integer id);





}