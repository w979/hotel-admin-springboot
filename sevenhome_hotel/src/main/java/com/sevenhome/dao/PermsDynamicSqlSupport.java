package com.sevenhome.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PermsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Perms perms = new Perms();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = perms.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> permName = perms.permName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> perCode = perms.perCode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> link = perms.link;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> parentid = perms.parentid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> permType = perms.permType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> permStatus = perms.permStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> icon = perms.icon;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Perms extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> permName = column("perm_name", JDBCType.VARCHAR);

        public final SqlColumn<String> perCode = column("per_code", JDBCType.VARCHAR);

        public final SqlColumn<String> link = column("link", JDBCType.VARCHAR);

        public final SqlColumn<Integer> parentid = column("parentid", JDBCType.INTEGER);

        public final SqlColumn<String> permType = column("perm_type", JDBCType.VARCHAR);

        public final SqlColumn<String> permStatus = column("perm_status", JDBCType.VARCHAR);

        public final SqlColumn<String> icon = column("icon", JDBCType.VARCHAR);

        public Perms() {
            super("perms");
        }
    }
}