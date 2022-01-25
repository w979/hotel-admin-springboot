package com.sevenhome.bean.vo;

import com.sevenhome.bean.po.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.List;

/**
 * lee
 */
@Data
public class EmployeeVo {

    @Id
    private Integer id;
    private String empname;
    private String sex;
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

    @Override
    public String toString() {
        return "EmployeeVo{" +
                "id=" + id +
                ", empname='" + empname + '\'' +
                ", sex='" + sex + '\'' +
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
