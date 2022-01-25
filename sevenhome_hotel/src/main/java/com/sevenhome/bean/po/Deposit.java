package com.sevenhome.bean.po;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.Generated;
@Data
public class Deposit implements Serializable {
    private Integer id;

    private BigDecimal depositTotal;

    private BigDecimal roomgoodsTotal;

    private BigDecimal depositReturnmoney;

    private Integer orderId;

    private String status;

    private Orders orders;


    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", depositTotal=" + depositTotal +
                ", roomgoodsTotal=" + roomgoodsTotal +
                ", depositReturnmoney=" + depositReturnmoney +
                ", orderId=" + orderId +
                ", status='" + status + '\'' +
                ", orders=" + orders +
                '}'+"\n";
    }
}