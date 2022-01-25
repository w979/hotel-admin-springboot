package com.sevenhome.controller;

import com.sevenhome.bean.vo.EveryDayBusinessVo;
import com.sevenhome.bean.vo.VisualDataVo;
import com.sevenhome.service.IVisualDataService;
import com.sevenhome.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * lee
 */
@RestController
public class VisualDataController {
    @Autowired
    private IVisualDataService iVisualDataService;

    /**
     * 查询总数据
     */
    @GetMapping("findAllData")
    public ResponseResult<Object> findAllData(){
        Double earning = iVisualDataService.findEarning();
        Double refund = iVisualDataService.findRefund();
        Integer orders = iVisualDataService.findOrders();
        Integer vips = iVisualDataService.findVips();

        HashMap<String, Object> map = new HashMap<>();
        map.put("earning",earning);
        map.put("refund",refund);
        map.put("orders",orders);
        map.put("vips",vips);
        return new ResponseResult<>(200,"总数据成功!",map);
    }

    /**
     * 查询各家店的订单信息
     */
    @GetMapping("findOrdersBySole")
    public ResponseResult<Object> findOrdersBySole(){
        List<VisualDataVo> ordersBySole = iVisualDataService.findOrdersBySole();
        System.out.println(ordersBySole.toString());
        return new ResponseResult<>(200,"查询各家店订单成功！",ordersBySole);
    }

    /**
     * 查询每日营业额
     */
    @GetMapping("findEverydayBusiness")
    public ResponseResult<Object> findEverydayBusiness(@RequestParam(value = "startDate",required = false,defaultValue = "2022-01-17") String startDate,@RequestParam(value = "endDate",required = false,defaultValue = "2022-01-23") String endDate){
        System.out.println("起始日期"+startDate);
        System.out.println("结束日期"+endDate);
        List<EveryDayBusinessVo> everydayBusiness = iVisualDataService.findEverydayBusiness(startDate, endDate);
        return new ResponseResult<>(200,"查询每日营业额成功！",everydayBusiness);
    }
}
