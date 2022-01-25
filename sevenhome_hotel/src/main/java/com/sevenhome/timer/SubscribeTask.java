package com.sevenhome.timer;


import com.sevenhome.bean.po.Orders;
import com.sevenhome.dao.OrdersDao;
import com.sevenhome.dao.SubscribeDao;
import com.sevenhome.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SubscribeTask {

    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private SubscribeDao subscribeDao;

    /**
     * 每隔2个小时执行一次查询
     */
    @Scheduled(cron = "0 0 */2 * * ?")
    public void updateSubscribeStatus(){
        long currentTime = new Date().getTime();
        List<Orders> orders = ordersDao.getAllOrders();
        //遍历orders计算差值，若超过24小时，则将其id放入一个数组中
        List<Integer> ids = new ArrayList<>();
        for (Orders o:orders){
            long generateTime = o.getOrderGeneratetime().getTime();
            //结束时间-开始时间
            long time = (currentTime-generateTime)/(60 * 60 * 1000);
            if(time>24){
                ids.add(o.getId());
            }
        }
        if(ids!=null) {
            //批量修改预订和订单表状态
            int n = subscribeDao.batUpdateSubscribeStatus(ids);
            int m = ordersDao.batUpdateOrderStatus(ids);
            System.out.println("subscribe表定时任务执行成功"+m+"次");
            System.out.println("orders表定时任务执行成功"+n+"次");
        }else {
            return;
        }

    }
}
