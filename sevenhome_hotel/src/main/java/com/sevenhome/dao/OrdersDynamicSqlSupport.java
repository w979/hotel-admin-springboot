package com.sevenhome.dao;

import java.math.BigDecimal;
import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class OrdersDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Orders orders = new Orders();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = orders.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> orderno = orders.orderno;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> subscribeId = orders.subscribeId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> checkinId = orders.checkinId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> orderTotalprice = orders.orderTotalprice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> orderStatus = orders.orderStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> orderGeneratetime = orders.orderGeneratetime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> roomId = orders.roomId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Orders extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> orderno = column("orderno", JDBCType.VARCHAR);

        public final SqlColumn<Integer> subscribeId = column("subscribe_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> checkinId = column("checkin_id", JDBCType.INTEGER);

        public final SqlColumn<BigDecimal> orderTotalprice = column("order_totalprice", JDBCType.DECIMAL);

        public final SqlColumn<String> orderStatus = column("order_status", JDBCType.VARCHAR);

        public final SqlColumn<Date> orderGeneratetime = column("order_generatetime", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> roomId = column("room_id", JDBCType.INTEGER);

        public Orders() {
            super("orders");
        }
    }
}