package com.sevenhome.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class VipDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Vip vip = new Vip();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = vip.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> vipNo = vip.vipNo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> vipStatus = vip.vipStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> vipRemark = vip.vipRemark;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> viptypeId = vip.viptypeId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> vipStarttime = vip.vipStarttime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> vipEndtime = vip.vipEndtime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> useronlineId = vip.useronlineId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Vip extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> vipNo = column("vip_no", JDBCType.VARCHAR);

        public final SqlColumn<String> vipStatus = column("vip_status", JDBCType.VARCHAR);

        public final SqlColumn<String> vipRemark = column("vip_remark", JDBCType.VARCHAR);

        public final SqlColumn<Integer> viptypeId = column("viptype_id", JDBCType.INTEGER);

        public final SqlColumn<Date> vipStarttime = column("vip_starttime", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> vipEndtime = column("vip_endtime", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> useronlineId = column("useronline_id", JDBCType.INTEGER);

        public Vip() {
            super("vip");
        }
    }
}