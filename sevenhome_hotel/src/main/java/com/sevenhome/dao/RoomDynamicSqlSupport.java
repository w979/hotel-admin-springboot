package com.sevenhome.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoomDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Room room = new Room();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = room.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> rommno = room.rommno;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> roomtypeId = room.roomtypeId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> roomFloor = room.roomFloor;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> roomStatus = room.roomStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> hotelId = room.hotelId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Room extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> rommno = column("rommno", JDBCType.VARCHAR);

        public final SqlColumn<Integer> roomtypeId = column("roomtype_id", JDBCType.INTEGER);

        public final SqlColumn<String> roomFloor = column("room_floor", JDBCType.VARCHAR);

        public final SqlColumn<String> roomStatus = column("room_status", JDBCType.VARCHAR);

        public final SqlColumn<Integer> hotelId = column("hotel_id", JDBCType.INTEGER);

        public Room() {
            super("room");
        }
    }
}