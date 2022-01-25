package com.sevenhome.dao;

import java.math.BigDecimal;
import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class EmployeeDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Employee employee = new Employee();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = employee.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> empname = employee.empname;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> sex = employee.sex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> username = employee.username;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> password = employee.password;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> empImg = employee.empImg;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> empNumber = employee.empNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> empSalary = employee.empSalary;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> empStatus = employee.empStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> hotelId = employee.hotelId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Employee extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> empname = column("empname", JDBCType.VARCHAR);

        public final SqlColumn<String> sex = column("sex", JDBCType.VARCHAR);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> empImg = column("emp_img", JDBCType.VARCHAR);

        public final SqlColumn<String> empNumber = column("emp_number", JDBCType.VARCHAR);

        public final SqlColumn<BigDecimal> empSalary = column("emp_salary", JDBCType.DECIMAL);

        public final SqlColumn<String> empStatus = column("emp_status", JDBCType.VARCHAR);

        public final SqlColumn<Integer> hotelId = column("hotel_id", JDBCType.INTEGER);

        public Employee() {
            super("employee");
        }
    }
}