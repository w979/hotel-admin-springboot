package com.sevenhome.service;

import com.sevenhome.bean.po.Hotel;

import java.util.List;

public interface IHotelService {
    //查询所有酒店信息
    List<Hotel> findAllHotel();
}
