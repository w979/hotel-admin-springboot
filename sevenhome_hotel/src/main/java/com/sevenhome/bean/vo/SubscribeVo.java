package com.sevenhome.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sevenhome.bean.po.Employee;
import com.sevenhome.bean.po.RoomType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * subscribeVo类
 */
@Data
public class SubscribeVo {

    private Integer id;

    private String subscribeName;

    private String subscribePhone;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date subscribeIntime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date subscribeLeavetime;

    private String roomTypeName;

    private Integer employeeId;

    private BigDecimal subscribeDeposit;

    private BigDecimal subscribeRoomrate;

    private String employeeName;

    private Integer subscribePaytype;

    private Integer subscribeStatus;

}
