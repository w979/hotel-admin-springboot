package com.sevenhome.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sevenhome.bean.po.UserOnline;
import com.sevenhome.bean.po.VipType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class VipDetailVo implements Serializable {
    private Integer id;

    private String vipNo;

    private String vipStatus;

    private String vipRemark;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date vipStarttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date vipEndtime;

    private Integer useronlineId;

    private String username;

    private String password;

    private String useronlinePhone;

    private BigDecimal useronlineTotalpay;

    private String useronlineSex;

    private String useronlineIdcard;

    private String viptypeName;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "VipDetailVo{" +
                "id=" + id +
                ", vipNo='" + vipNo + '\'' +
                ", vipStatus='" + vipStatus + '\'' +
                ", vipRemark='" + vipRemark + '\'' +
                ", vipStarttime=" + vipStarttime +
                ", vipEndtime=" + vipEndtime +
                ", useronlineId=" + useronlineId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", useronlinePhone='" + useronlinePhone + '\'' +
                ", useronlineTotalpay=" + useronlineTotalpay +
                ", useronlineSex='" + useronlineSex + '\'' +
                ", useronlineIdcard='" + useronlineIdcard + '\'' +
                ", viptypeName='" + viptypeName + '\'' +
                '}';
    }
}