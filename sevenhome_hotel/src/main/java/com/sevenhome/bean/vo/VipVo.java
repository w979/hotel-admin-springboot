package com.sevenhome.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sevenhome.bean.po.VipType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class VipVo implements Serializable {
    private Integer id;

    private String vipNo;

    private String vipStatus;

    private String username;

    private Integer viptypeId;

    private BigDecimal useronlineTotalpay;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "VipVo{" +
                "id=" + id +
                ", vipNo='" + vipNo + '\'' +
                ", vipStatus='" + vipStatus + '\'' +
                ", username='" + username + '\'' +
                ", viptypeId=" + viptypeId +
                ", useronlineTotalpay=" + useronlineTotalpay +
                '}'+"\n";
    }
}