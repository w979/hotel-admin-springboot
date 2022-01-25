package com.sevenhome.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class VipTypeDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final VipType vipType = new VipType();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = vipType.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> viptypeName = vipType.viptypeName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> viptypeLevel = vipType.viptypeLevel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> viptypeDiscount = vipType.viptypeDiscount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> viptypeStep = vipType.viptypeStep;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class VipType extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> viptypeName = column("viptype_name", JDBCType.VARCHAR);

        public final SqlColumn<String> viptypeLevel = column("viptype_level", JDBCType.VARCHAR);

        public final SqlColumn<String> viptypeDiscount = column("viptype_discount", JDBCType.VARCHAR);

        public final SqlColumn<String> viptypeStep = column("viptype_step", JDBCType.VARCHAR);

        public VipType() {
            super("viptype");
        }
    }
}