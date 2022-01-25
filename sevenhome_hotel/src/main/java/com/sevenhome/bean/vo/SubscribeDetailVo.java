package com.sevenhome.bean.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sevenhome.bean.po.Employee;
import com.sevenhome.bean.po.RoomType;
import com.sevenhome.bean.po.Vip;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * SubscribeDetailVo类
 */
@Data
public class SubscribeDetailVo {

    private Integer id;

    private String subscribeName;

    private String subscribePhone;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date subscribeIntime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date subscribeLeavetime;

    private Integer subscribePaytype;

    private Integer subscribeStatus;

    private Integer subscribeOrigin;

    private BigDecimal subscribeDeposit;

    private BigDecimal subscribeRoomrate;

    private RoomType roomType;

    private Employee employee;

    private Vip vip;
}
