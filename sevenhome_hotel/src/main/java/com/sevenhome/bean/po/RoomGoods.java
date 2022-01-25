package com.sevenhome.bean.po;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.Generated;
@Data
public class RoomGoods implements Serializable {
    private Integer id;

    private String roomgoodsName;

    private BigDecimal roomgoodsPrice;

    private String goodstype;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "RoomGoods{" +
                "id=" + id +
                ", roomgoodsName='" + roomgoodsName + '\'' +
                ", roomgoodsPrice=" + roomgoodsPrice +
                ", goodstype='" + goodstype + '\'' +
                '}' + "\n";
    }


}