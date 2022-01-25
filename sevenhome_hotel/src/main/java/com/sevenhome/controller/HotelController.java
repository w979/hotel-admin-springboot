package com.sevenhome.controller;

import com.sevenhome.bean.po.Hotel;
import com.sevenhome.service.IHotelService;
import com.sevenhome.utils.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HotelController {
    @Resource
    private IHotelService hotelService;

    /**
     * 酒店列表查询
     * @return
     */
    @GetMapping("hotel/list")
    public ResponseResult<Object> findAll(){
        List<Hotel> hotelList = hotelService.findAllHotel();
        return  new ResponseResult<>(200, "所有酒店列表",hotelList);
    }
}
