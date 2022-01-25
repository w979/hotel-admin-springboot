package com.sevenhome.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class DepositDetailDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final DepositDetail depositDetail = new DepositDetail();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = depositDetail.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> roomgoodsId = depositDetail.roomgoodsId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> depositdetailNum = depositDetail.depositdetailNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> depositId = depositDetail.depositId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class DepositDetail extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> roomgoodsId = column("roomgoods_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> depositdetailNum = column("depositdetail_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> depositId = column("deposit_id", JDBCType.INTEGER);

        public DepositDetail() {
            super("depositdetail");
        }
    }
}