package com.sevenhome.bean.fo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CheckinFo {

    private Integer id;

    private String checkinName;

    private String checkinIdcard;

    private String ckeckinPhone;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date checkinIntime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date checkinLeavetime;

    private BigDecimal checkinDeposit;

    private BigDecimal checkinRoomrate;

    private String vipNo;

    private String checkinOrigin;

    private String roomId;

    private Integer checkinPaytype;

    private String checkinRemark;

    private String employeeId;

    private Integer subscribeId;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "CheckinFo{" +
                "id=" + id +
                ", checkinName='" + checkinName + '\'' +
                ", checkinIdcard='" + checkinIdcard + '\'' +
                ", ckeckinPhone='" + ckeckinPhone + '\'' +
                ", checkinIntime=" + checkinIntime +
                ", checkinLeavetime=" + checkinLeavetime +
                ", checkinDeposit=" + checkinDeposit +
                ", checkinRoomrate=" + checkinRoomrate +
                ", vipNo=" + vipNo +
                ", checkinOrigin='" + checkinOrigin + '\'' +
                ", roomId=" + roomId +
                ", checkinPaytype=" + checkinPaytype +
                ", checkinRemark='" + checkinRemark + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }
}
