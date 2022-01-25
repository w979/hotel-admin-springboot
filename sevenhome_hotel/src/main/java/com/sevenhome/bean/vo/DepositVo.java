package com.sevenhome.bean.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 押金列表Vo
 */
@Data
public class DepositVo {
    private Integer id;
    private String roomno;
    private String checkinName;
    private BigDecimal money;
    private String status; //押金状态
    private Integer hotelId;
    private String hotelname;
}
