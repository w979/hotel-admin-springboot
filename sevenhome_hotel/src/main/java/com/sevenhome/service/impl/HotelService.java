package com.sevenhome.service.impl;

import com.sevenhome.bean.po.Hotel;
import com.sevenhome.dao.HotelDao;
import com.sevenhome.service.IHotelService;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class HotelService implements IHotelService {

    @Resource
    private HotelDao hotelDao;

    /**
     * 查询所有酒店
     * @return
     */
    @Override
    public List<Hotel> findAllHotel() {
        SelectDSLCompleter completer = c->c;
        return hotelDao.select(completer);
    }
}
