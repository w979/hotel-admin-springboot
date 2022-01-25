package com.sevenhome.service;

import com.sevenhome.bean.po.RoomStatus;

import java.util.Date;

public interface IRoomStatusService {

    int delRoomStatusByDateAndRoomId(Date updateLeaveTime,Integer roomId);


    int delRoomStatusByNewLeaveDateAndOldLeaveDate(Date newLeaveDate,Date oldLeaveDate,Integer roomId);
}
