package com.sevenhome.service;

import com.sevenhome.bean.fo.SubscribeFo;
import com.sevenhome.bean.po.Deposit;
import com.sevenhome.bean.po.Orders;
import com.github.pagehelper.PageInfo;
import com.sevenhome.bean.vo.CheckOutRoomVo;
import com.sevenhome.bean.vo.OrdersVo;


import java.util.List;

public interface IOrdersService {

    List<String> outHotelTimeList(String orderno);

    String getOrderNoByRoomId(Integer roomid);

    Orders getOrdersByOrderNo(String orderno);

    int updateOrders(Orders orders);

    int updateOrdersStatus(Integer id,String status);
    /**
     * 查询所有订单信息-线上
     */
    PageInfo<OrdersVo> QueryAllOrders(Integer pageNo, Integer pageSize, String name, String orderno, String status, Integer hotelid);

    int insertOrder(SubscribeFo subscribeFo) throws Exception;

    List<Integer> getRoomidByCheckinId(List<Integer> checkinIds);

    PageInfo<CheckOutRoomVo> getLeaveRoomList(Integer hotelid, String roomno, Integer pageno);

    /**
     * 查询所有订单信息-线下
     */
    PageInfo<OrdersVo> QueryAllOrdersReality(Integer pageNo, Integer pageSize, String name, String orderno, String status, Integer hotelid);



}
