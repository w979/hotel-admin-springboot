package com.sevenhome.bean.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@EnableRedisRepositories
public class Employee implements Serializable {
    @Id
    private Integer id;

    private String empname;
    private String sex;
    private String username;
    private String password;
    private String empImg;
    private String empNumber;
    private BigDecimal empSalary;
    private String empStatus;
    private Integer hotelId;
    private List<String> permList;
    /**
     * 员工对应部门
     */
    private Role role;
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empname='" + empname + '\'' +
                ", sex='" + sex + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", empImg='" + empImg + '\'' +
                ", empNumber='" + empNumber + '\'' +
                ", empSalary=" + empSalary +
                ", empStatus='" + empStatus + '\'' +
                ", hotelId=" + hotelId +
                ", permList=" + permList +
                ", role=" + role +
                '}';
    }
}