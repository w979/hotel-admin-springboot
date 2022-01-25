package com.sevenhome.service;

import com.sevenhome.bean.po.Room;
import com.sevenhome.bean.vo.RoomVo;
import com.sevenhome.bean.vo.RoomVoPageInfo;

import java.util.Date;
import java.util.List;

public interface IRoomService {

    Integer getRoomId(Integer roomno,Integer hotelid);

    /**
     * 房态分页
     * @param username
     * @param pageNum
     * @param pageSize
     * @return
     */
    RoomVoPageInfo roomStatusTbale(String username, String today, Integer pageNum, Integer pageSize);

    /**
     * 查询预订房间信息
     * @param roomNo
     * @return
     */
    RoomVo getSubscribeRoom(String roomNo);




    /**
     * 修改房间状态为脏
     * @param roomid
     * @return
     */
    int updateRoomStatustoDirty(Integer roomid);

    /**
     * 获得所有今天要退房的房间对象
     * @param roomids
     * @return
     */
    List<Room> getAllRoomLeaveOnToday(List<Integer> roomids);
}
