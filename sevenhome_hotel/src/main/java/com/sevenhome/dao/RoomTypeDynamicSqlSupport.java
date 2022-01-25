package com.sevenhome.dao;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoomTypeDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final RoomType roomType = new RoomType();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = roomType.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> roomtypeName = roomType.roomtypeName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> marketPrice = roomType.marketPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> onlinePrice = roomType.onlinePrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> roomtypeStatus = roomType.roomtypeStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> roomtypeArea = roomType.roomtypeArea;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> bedNumber = roomType.bedNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> bedType = roomType.bedType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> breakfast = roomType.breakfast;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> smoking = roomType.smoking;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class RoomType extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> roomtypeName = column("roomtype_name", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> marketPrice = column("market_price", JDBCType.DECIMAL);

        public final SqlColumn<BigDecimal> onlinePrice = column("online_price", JDBCType.DECIMAL);

        public final SqlColumn<String> roomtypeStatus = column("roomtype_status", JDBCType.VARCHAR);

        public final SqlColumn<String> roomtypeArea = column("roomtype_area", JDBCType.VARCHAR);

        public final SqlColumn<Integer> bedNumber = column("bed_number", JDBCType.INTEGER);

        public final SqlColumn<String> bedType = column("bed_type", JDBCType.VARCHAR);

        public final SqlColumn<String> breakfast = column("breakfast", JDBCType.VARCHAR);

        public final SqlColumn<String> smoking = column("smoking", JDBCType.VARCHAR);

        public RoomType() {
            super("roomtype");
        }
    }
}