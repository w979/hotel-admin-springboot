package com.sevenhome.bean.vo;

import lombok.Data;

@Data
public class VisualDataVo {


    private Integer num;

    private String hotelname;

    @Override
    public String toString() {
        return "VisualDataVo{" +
                "num=" + num +
                ", hotelname='" + hotelname + '\'' +
                '}';
    }
}
