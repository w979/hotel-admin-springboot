package com.sevenhome.service;

import com.sevenhome.bean.po.RoomType;

import java.util.List;

public interface IRoomTypeService {

    //查询房型列表下拉框
    List<RoomType> getRoomTypeList();
}
