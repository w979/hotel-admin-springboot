package com.sevenhome.service;

import com.sevenhome.bean.vo.EveryDayBusinessVo;
import com.sevenhome.bean.vo.VisualDataVo;

import java.util.List;

public interface IVisualDataService {

    /**
     * 总收入
     * @return
     */
    Double findEarning();

    /**
     * 总退款
     * @return
     */
    Double findRefund();

    /**
     * 总订单
     * @return
     */
    Integer findOrders();

    /**
     * 总Vip
     * @return
     */
    Integer findVips();

    /**
     * 查询各家店的订单信息
     * @return
     */
    List<VisualDataVo> findOrdersBySole();

    List<EveryDayBusinessVo> findEverydayBusiness(String startDate, String endDate);
}
