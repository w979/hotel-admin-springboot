package com.sevenhome.dao;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SubscribeDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Subscribe subscribe = new Subscribe();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = subscribe.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> subscribeName = subscribe.subscribeName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> subscribePhone = subscribe.subscribePhone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> subscribeIntime = subscribe.subscribeIntime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> subscribeLeavetime = subscribe.subscribeLeavetime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> subscribeOrigin = subscribe.subscribeOrigin;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> subscribeDeposit = subscribe.subscribeDeposit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> subscribeRoomrate = subscribe.subscribeRoomrate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> vipId = subscribe.vipId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> roomtypeId = subscribe.roomtypeId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> employeeId = subscribe.employeeId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> subscribePaytype = subscribe.subscribePaytype;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> subscribeStatus = subscribe.subscribeStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Subscribe extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> subscribeName = column("subscribe_name", JDBCType.VARCHAR);

        public final SqlColumn<String> subscribePhone = column("subscribe_phone", JDBCType.VARCHAR);

        public final SqlColumn<Date> subscribeIntime = column("subscribe_intime", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> subscribeLeavetime = column("subscribe_leavetime", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> subscribeOrigin = column("subscribe_origin", JDBCType.INTEGER);

        public final SqlColumn<BigDecimal> subscribeDeposit = column("subscribe_deposit", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> subscribeRoomrate = column("subscribe_roomrate", JDBCType.DECIMAL);

        public final SqlColumn<Integer> vipId = column("vip_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> roomtypeId = column("roomtype_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> employeeId = column("employee_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> subscribePaytype = column("subscribe_paytype", JDBCType.INTEGER);

        public final SqlColumn<Integer> subscribeStatus = column("subscribe_status", JDBCType.INTEGER);

        public Subscribe() {
            super("subscribe");
        }
    }
}