package com.sevenhome.controller;

import com.github.pagehelper.PageInfo;
import com.sevenhome.bean.vo.OrdersVo;
import com.sevenhome.service.IOrdersService;
import com.sevenhome.utils.ResponseResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrdersController {

    @Resource
    private IOrdersService ordersService;

    /**
     * @author wry
     * @date 2022/1/17 14:55
     *显示订单列表-线上
     * @param pageNum
     * @param pageSize
     * @param status
     * @param hotelid
     * @return
     */
     @GetMapping("order/list")
     @PreAuthorize("hasAuthority('order:list')")
    public ResponseResult<Object> queryAllOrders(@RequestParam(value = "pageNum",required = false,defaultValue = "") Integer pageNum,
                                                 @RequestParam(value = "pageSize",required = false,defaultValue = "")Integer pageSize,
                                                 @RequestParam(value = "subscibeName",required = false,defaultValue = "") String subscibeName,
                                                 @RequestParam(value = "orderno",required = false,defaultValue = "") String orderno,
                                                 @RequestParam(value = "status",required = false,defaultValue = "") String  status,
                                                 @RequestParam(value = "hotelid",required = false,defaultValue = "") Integer hotelid){
        PageInfo<OrdersVo> pageInfo = ordersService.QueryAllOrders(pageNum, pageSize, subscibeName, orderno, status, hotelid);

        return new ResponseResult<>(200, "订单列表",pageInfo);
    }

    /**
     * 修改订单状态
     * @author wry
     * @date 2022/1/19 23:15
     * @param id
     * @param status
     * @return
     */
    @GetMapping("order/update")
    @PreAuthorize("hasAuthority('order:update')")
    public ResponseResult<Void> updateDeposit(@RequestParam(value = "id",required = false,defaultValue = "") Integer id,
                                              @RequestParam(value = "status",required = false,defaultValue = "") String status){
        int n = ordersService.updateOrdersStatus(id, status);
        if (n > 0){
            return new ResponseResult<>(200, "订单状态修改成功");
        }else {
            return new ResponseResult<>(501, "订单状态修改失败");
        }
    }

    /**
     * @author wry
     * @date 2022/1/17 14:55
     *显示订单列表-线上
     * @param pageNum
     * @param pageSize
     * @param status
     * @param hotelid
     * @return
     */
    @GetMapping("order/reality")
    @PreAuthorize("hasAuthority('order:reality')")
    public ResponseResult<Object> queryAllOrdersReality(@RequestParam(value = "pageNum",required = false,defaultValue = "") Integer pageNum,
                                                 @RequestParam(value = "pageSize",required = false,defaultValue = "")Integer pageSize,
                                                 @RequestParam(value = "checkinName",required = false,defaultValue = "") String checkinName,
                                                 @RequestParam(value = "orderno",required = false,defaultValue = "") String orderno,
                                                 @RequestParam(value = "status",required = false,defaultValue = "") String  status,
                                                 @RequestParam(value = "hotelid",required = false,defaultValue = "") Integer hotelid){
        PageInfo<OrdersVo> pageInfo = ordersService.QueryAllOrdersReality(pageNum, pageSize, checkinName, orderno, status, hotelid);

        return new ResponseResult<>(200, "线下订单列表",pageInfo);
    }
}
