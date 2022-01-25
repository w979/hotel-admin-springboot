package com.sevenhome.bean.po;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.Generated;
@Data
public class RoomType implements Serializable {
    private Integer id;

    private String roomtypeName;

    private BigDecimal marketPrice;

    private BigDecimal onlinePrice;

    private String roomtypeStatus;

    private String roomtypeArea;

    private Integer bedNumber;

    private String bedType;

    private String breakfast;

    private String smoking;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", roomtypeName='" + roomtypeName + '\'' +
                ", marketPrice=" + marketPrice +
                ", onlinePrice=" + onlinePrice +
                ", roomtypeStatus='" + roomtypeStatus + '\'' +
                ", roomtypeArea='" + roomtypeArea + '\'' +
                ", bedNumber=" + bedNumber +
                ", bedType='" + bedType + '\'' +
                ", breakfast='" + breakfast + '\'' +
                ", smoking='" + smoking + '\'' +
                '}' + "\n";
    }
}