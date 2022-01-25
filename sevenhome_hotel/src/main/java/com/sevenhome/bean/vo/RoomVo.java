package com.sevenhome.bean.vo;

import com.sevenhome.bean.po.RoomStatus;
import com.sevenhome.bean.po.RoomType;
import lombok.Data;

@Data
public class RoomVo {

    private Integer id;

    private String rommno;

    private Integer roomtypeId;

    private String roomFloor;

    private String roomStatus;

    private Integer hotelId;
    /**
     * 房间类型映射
     */
    private RoomType roomType;
    /**
     * 房间状态映射
     */
    private RoomStatus rs;

    @Override
    public String toString() {
        return "RoomVo{" +
                "id=" + id +
                ", rommno='" + rommno + '\'' +
                ", roomtypeId=" + roomtypeId +
                ", roomFloor='" + roomFloor + '\'' +
                ", roomStatus='" + roomStatus + '\'' +
                ", hotelId=" + hotelId +
                ", roomType=" + roomType +
                ", rs=" + rs +
                '}';
    }
}
