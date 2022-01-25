package com.sevenhome.dao;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class DepositDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Deposit deposit = new Deposit();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = deposit.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> depositTotal = deposit.depositTotal;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> roomgoodsTotal = deposit.roomgoodsTotal;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> depositReturnmoney = deposit.depositReturnmoney;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> orderId = deposit.orderId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> status = deposit.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Deposit extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<BigDecimal> depositTotal = column("deposit_total", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> roomgoodsTotal = column("roomgoods_total", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> depositReturnmoney = column("deposit_returnmoney", JDBCType.DECIMAL);

        public final SqlColumn<Integer> orderId = column("order_id", JDBCType.INTEGER);

        public final SqlColumn<String> status = column("status", JDBCType.VARCHAR);

        public Deposit() {
            super("deposit");
        }
    }
}