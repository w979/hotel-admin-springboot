package com.sevenhome.bean.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
@Data
public class Subscribe implements Serializable {
    private Integer id;

    private String subscribeName;

    private String subscribePhone;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date subscribeIntime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date subscribeLeavetime;

    private Integer subscribeOrigin;

    private BigDecimal subscribeDeposit;

    private BigDecimal subscribeRoomrate;

    private Integer vipId;

    private Integer roomtypeId;

    private Integer employeeId;

    private Integer subscribePaytype;

    private Integer subscribeStatus;

    private RoomType roomType;

    private Employee employee;

    private Vip vip;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Subscribe{" +
                "id=" + id +
                ", subscribeName='" + subscribeName + '\'' +
                ", subscribePhone='" + subscribePhone + '\'' +
                ", subscribeIntime=" + subscribeIntime +
                ", subscribeLeavetime=" + subscribeLeavetime +
                ", subscribeOrigin=" + subscribeOrigin +
                ", subscribeDeposit=" + subscribeDeposit +
                ", subscribeRoomrate=" + subscribeRoomrate +
                ", vipId=" + vipId +
                ", roomtypeId=" + roomtypeId +
                ", employeeId=" + employeeId +
                ", subscribePaytype=" + subscribePaytype +
                ", subscribeStatus=" + subscribeStatus +
                '}' + "\n";
    }
}