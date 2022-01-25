package com.sevenhome.dao;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CheckInDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final CheckIn checkIn = new CheckIn();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = checkIn.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> checkinName = checkIn.checkinName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> checkinIdcard = checkIn.checkinIdcard;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> ckeckinPhone = checkIn.ckeckinPhone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> checkinIntime = checkIn.checkinIntime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> checkinLeavetime = checkIn.checkinLeavetime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> checkinDeposit = checkIn.checkinDeposit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> checkinRoomrate = checkIn.checkinRoomrate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> vipId = checkIn.vipId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> checkinOrigin = checkIn.checkinOrigin;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> roomId = checkIn.roomId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> checkinPaytype = checkIn.checkinPaytype;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> checkinRemark = checkIn.checkinRemark;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> employeeId = checkIn.employeeId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class CheckIn extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> checkinName = column("checkin_name", JDBCType.VARCHAR);

        public final SqlColumn<String> checkinIdcard = column("checkin_idcard", JDBCType.VARCHAR);

        public final SqlColumn<String> ckeckinPhone = column("ckeckin_phone", JDBCType.VARCHAR);

        public final SqlColumn<Date> checkinIntime = column("checkin_intime", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> checkinLeavetime = column("checkin_leavetime", JDBCType.TIMESTAMP);

        public final SqlColumn<BigDecimal> checkinDeposit = column("checkin_deposit", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> checkinRoomrate = column("checkin_roomrate", JDBCType.DECIMAL);

        public final SqlColumn<Integer> vipId = column("vip_id", JDBCType.INTEGER);

        public final SqlColumn<String> checkinOrigin = column("checkin_origin", JDBCType.VARCHAR);

        public final SqlColumn<Integer> roomId = column("room_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> checkinPaytype = column("checkin_paytype", JDBCType.INTEGER);

        public final SqlColumn<String> checkinRemark = column("checkin_remark", JDBCType.VARCHAR);

        public final SqlColumn<String> employeeId = column("employee_id", JDBCType.VARCHAR);

        public CheckIn() {
            super("check_in");
        }
    }
}