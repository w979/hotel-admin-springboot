package com.sevenhome.service.impl;

import com.sevenhome.bean.po.RoomStatus;
import com.sevenhome.dao.RoomStatusDao;
import com.sevenhome.dao.RoomStatusDynamicSqlSupport;
import com.sevenhome.service.IRoomStatusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class RoomStatusService implements IRoomStatusService {
    @Resource
    private RoomStatusDao roomStatusDao;
    @Override
    public int delRoomStatusByDateAndRoomId(Date updateLeaveTime, Integer roomId) {
        return roomStatusDao.delRoomStatusByDateAndRoomId(updateLeaveTime,roomId);
    }

    @Override
    public int delRoomStatusByNewLeaveDateAndOldLeaveDate(Date newLeaveDate, Date oldLeaveDate, Integer roomId) {
        return roomStatusDao.delRoomStatusByNewLeaveDateAndOldLeaveDate(newLeaveDate,oldLeaveDate,roomId);
    }
}
