package com.sevenhome.bean.po;

import lombok.Data;

import java.io.Serializable;
import javax.annotation.Generated;
@Data
public class Business implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer grorderId;
    /**
     * 订单表映射
     */
    private Orders orders;

    /**
     * 房间表映射
     */
    private Room room;

    /**
     * 押金表映射
     */
    private Deposit deposit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", grorderId=" + grorderId +
                ", orders=" + orders +
                ", room=" + room +
                ", deposit=" + deposit +
                '}';
    }
}