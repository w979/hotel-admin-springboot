package com.sevenhome.dao;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoomGoodsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final RoomGoods roomGoods = new RoomGoods();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = roomGoods.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> roomgoodsName = roomGoods.roomgoodsName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> roomgoodsPrice = roomGoods.roomgoodsPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> goodstype = roomGoods.goodstype;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class RoomGoods extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> roomgoodsName = column("roomgoods_name", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> roomgoodsPrice = column("roomgoods_price", JDBCType.DECIMAL);

        public final SqlColumn<String> goodstype = column("goodstype", JDBCType.VARCHAR);

        public RoomGoods() {
            super("roomgoods");
        }
    }
}