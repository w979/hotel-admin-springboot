package com.sevenhome.bean.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserOnlineVo {

    private String username;
    private BigDecimal useronlineTotalpay;
}
