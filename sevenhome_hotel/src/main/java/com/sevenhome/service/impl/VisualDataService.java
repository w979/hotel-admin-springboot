package com.sevenhome.service.impl;

import com.sevenhome.bean.vo.EveryDayBusinessVo;
import com.sevenhome.bean.vo.VisualDataVo;
import com.sevenhome.dao.OrdersDao;
import com.sevenhome.dao.SubscribeDao;
import com.sevenhome.dao.VipDao;
import com.sevenhome.service.IVisualDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisualDataService implements IVisualDataService {
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private SubscribeDao subscribeDao;
    @Autowired
    private VipDao vipDao;

    /**
     * 总收入
     * @return
     */
    @Override
    public Double findEarning() {
        return ordersDao.findEarning();
    }

    /**
     * 总退款
     * @return
     */
    @Override
    public Double findRefund() {
        return subscribeDao.findRefund();
    }

    /**
     * 总订单
     * @return
     */
    @Override
    public Integer findOrders() {
        return ordersDao.findOrders();
    }

    /**
     * 总Vip
     * @return
     */
    @Override
    public Integer findVips() {
        return vipDao.findVips();
    }

    /**
     * 查询各家店的订单信息
     * @return
     */
    @Override
    public List<VisualDataVo> findOrdersBySole() {
        return ordersDao.findOrdersBySole();
    }

    /**
     * 每日营业额
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List<EveryDayBusinessVo> findEverydayBusiness(String startDate, String endDate) {
        return ordersDao.findEverydayBusiness(startDate,endDate);
    }
}
