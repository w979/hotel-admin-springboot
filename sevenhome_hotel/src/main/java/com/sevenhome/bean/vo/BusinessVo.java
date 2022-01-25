package com.sevenhome.bean.vo;

import lombok.Data;

@Data
public class BusinessVo {
    private Integer id;
    private String orderno;
    private String rommno;
    private String roomFloor;
    private String roomStatus;
    /**
     * 押金表外键
     */
    private Integer depositId;
}
