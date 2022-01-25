package com.sevenhome.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoomStatusDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final RoomStatus roomStatus = new RoomStatus();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = roomStatus.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> roomId = roomStatus.roomId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> roomstatus = roomStatus.roomstatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> roomstatusDate = roomStatus.roomstatusDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class RoomStatus extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> roomId = column("room_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> roomstatus = column("roomstatus", JDBCType.INTEGER);

        public final SqlColumn<Date> roomstatusDate = column("roomstatus_date", JDBCType.TIMESTAMP);

        public RoomStatus() {
            super("roomstatus");
        }
    }
}