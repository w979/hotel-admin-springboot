package com.sevenhome.bean.po;

import lombok.Data;

import java.io.Serializable;
import javax.annotation.Generated;
@Data
public class Hotel implements Serializable {
    private Integer id;

    private String hotelName;

    private String area;

    private String detailAddress;

    private String longitude;

    private String latitude;

    private String hotelPhone;

    private String hotelDescription;

    private String homepageImg;

    private String detailImg;

    private String hotelFacility;

    private String hotelStatus;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", area='" + area + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", hotelPhone='" + hotelPhone + '\'' +
                ", hotelDescription='" + hotelDescription + '\'' +
                ", homepageImg='" + homepageImg + '\'' +
                ", detailImg='" + detailImg + '\'' +
                ", hotelFacility='" + hotelFacility + '\'' +
                ", hotelStatus='" + hotelStatus + '\'' +
                '}' + "\n";
    }
}