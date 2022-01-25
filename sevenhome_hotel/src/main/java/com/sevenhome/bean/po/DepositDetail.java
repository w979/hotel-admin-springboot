package com.sevenhome.bean.po;

import lombok.Data;

import java.io.Serializable;
import javax.annotation.Generated;

@Data
public class DepositDetail implements Serializable {
    private Integer id;

    private Integer roomgoodsId;

    private Integer depositdetailNum;

    private Integer depositId;

    private RoomGoods roomGoods;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "DepositDetail{" +
                "id=" + id +
                ", roomgoodsId=" + roomgoodsId +
                ", depositdetailNum=" + depositdetailNum +
                ", depositId=" + depositId +
                '}' + "\n";
    }


}