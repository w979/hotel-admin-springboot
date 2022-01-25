package com.sevenhome.bean.po;

import lombok.Data;

import java.io.Serializable;
import javax.annotation.Generated;
@Data
public class Room implements Serializable {
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

    //酒店对象属性
    private Hotel hotel;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Room{" +
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