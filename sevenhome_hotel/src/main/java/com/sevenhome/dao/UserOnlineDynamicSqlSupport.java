package com.sevenhome.dao;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserOnlineDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UserOnline userOnline = new UserOnline();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = userOnline.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> username = userOnline.username;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> password = userOnline.password;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> useronlinePhone = userOnline.useronlinePhone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> useronlineAvatar = userOnline.useronlineAvatar;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> useronlineTotalpay = userOnline.useronlineTotalpay;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> useronlineSex = userOnline.useronlineSex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> useronlineIdcard = userOnline.useronlineIdcard;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UserOnline extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> useronlinePhone = column("useronline_phone", JDBCType.VARCHAR);

        public final SqlColumn<String> useronlineAvatar = column("useronline_avatar", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> useronlineTotalpay = column("useronline_totalpay", JDBCType.DECIMAL);

        public final SqlColumn<String> useronlineSex = column("useronline_sex", JDBCType.VARCHAR);

        public final SqlColumn<String> useronlineIdcard = column("useronline_idcard", JDBCType.VARCHAR);

        public UserOnline() {
            super("useronline");
        }
    }
}