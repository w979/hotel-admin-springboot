package com.sevenhome.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sevenhome.bean.po.Employee;
import com.sevenhome.bean.po.Room;
import com.sevenhome.bean.vo.RoomVo;
import com.sevenhome.bean.vo.RoomVoPageInfo;
import com.sevenhome.bean.vo.SubscribeVoPageInfo;
import com.sevenhome.dao.EmployeeDao;
import com.sevenhome.dao.RoomDao;
import com.sevenhome.service.IRoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * lee,hehao
 */
@Service
@Transactional
public class RoomService implements IRoomService {
    @Resource
    private RoomDao roomDao;
    @Resource
    private EmployeeDao employeeDao;


    /**
     * 根据房间编号，酒店主键获得房间主键
     * hh
     * @param roomno
     * @param hotelid
     * @return
     */
    @Override
    public Integer getRoomId(Integer roomno, Integer hotelid) {
        return roomDao.getRoomId(roomno,hotelid);
    }


    /**
     * 房态
     * @author lee
     * @param username
     * @return
     */
    @Override
    public RoomVoPageInfo roomStatusTbale(String username, String today,Integer pageNum, Integer pageSize) {
        /**
         * 根据当前登陆人username查询他的信息拿到所属酒店id
         */
        Employee employeeByUserName = employeeDao.findEmployeeByUserName(username);
        List<Room> all = roomDao.findAllRoom(employeeByUserName.getHotelId(),today);
        System.out.println("转化前的值"+all.toString());
        PageHelper.startPage(pageNum,pageSize);
        /**
         * 查询指定酒店的所有房间及房间状态
         */
        List<Room> allRoom = roomDao.findAllRoom(employeeByUserName.getHotelId(),today);
        PageInfo<Room> roomPageInfo = new PageInfo<>(allRoom);
        ArrayList<RoomVo> roomVos = new ArrayList<>();
        for (Room room : allRoom){
            RoomVo roomVo = new RoomVo();
            roomVo.setId(room.getId());
            roomVo.setRommno(room.getRommno());
            roomVo.setRoomtypeId(room.getRoomtypeId());
            roomVo.setRoomFloor(room.getRoomFloor());
            roomVo.setRoomStatus(room.getRoomStatus());
            roomVo.setHotelId(room.getHotelId());
            roomVo.setRoomType(room.getRoomType());
            roomVo.setRs(room.getRs());
            roomVos.add(roomVo);
        }

        //对象转换中，pageinfo中数据会丢失，所以在这里对paginfo中的数据做转换处理
        RoomVoPageInfo pageInfo = new RoomVoPageInfo();
        pageInfo.setPageNum(roomPageInfo.getPageNum());
        pageInfo.setPageSize(roomPageInfo.getPageSize());
        pageInfo.setPages(roomPageInfo.getPages());
        pageInfo.setTotal(roomPageInfo.getTotal());
        pageInfo.setRoomVoList(roomVos);

        return pageInfo;
    }

    @Override
    public int updateRoomStatustoDirty(Integer roomid) {
        return roomDao.updateRoomStatusToDirty(roomid);
    }

    @Override
    public List<Room> getAllRoomLeaveOnToday(List<Integer> roomids) {
        return roomDao.getAllRoomLeaveOnToday(roomids);
    }

    /**
     * 查询预订房间信息
     * @param roomNo
     * @return
     */
    @Override
    public RoomVo getSubscribeRoom(String roomNo) {
        RoomVo roomVo = new RoomVo();
        Room room = roomDao.getSubscribeRoom(roomNo);
        BeanUtils.copyProperties(room, roomVo);
        return roomVo;
    }
}
