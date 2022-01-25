package com.sevenhome.bean.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepositDetailVo {
    private String goodsname;//商品名称
    private BigDecimal price; //价格
    private Integer num;//数量
    private String goodstype; //商品类型
    private BigDecimal total;//合计

    @Override
    public String toString() {
        return "DepositDetailVo{" +
                "goodsname='" + goodsname + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", goodstype='" + goodstype + '\'' +
                ", total=" + total +
                '}';
    }
}
