package com.sevenhome.service.impl;

import com.sevenhome.bean.po.RoomType;
import com.sevenhome.dao.RoomTypeDao;
import com.sevenhome.service.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomTypeService implements IRoomTypeService {

    @Autowired
    private RoomTypeDao roomTypeDao;

    /**
     * 查询所有房型列表下拉框
     * @return
     */
    @Override
    public List<RoomType> getRoomTypeList() {
        return roomTypeDao.getRoomTypeList();
    }
}
