package com.sevenhome.bean.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
@Data
public class CheckIn implements Serializable {
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

    private Integer vipId;

    private String checkinOrigin;

    private Integer roomId;

    private Integer checkinPaytype;

    private String checkinRemark;

    private String employeeId;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "CheckIn{" +
                "id=" + id +
                ", checkinName='" + checkinName + '\'' +
                ", checkinIdcard='" + checkinIdcard + '\'' +
                ", ckeckinPhone='" + ckeckinPhone + '\'' +
                ", checkinIntime=" + checkinIntime +
                ", checkinLeavetime=" + checkinLeavetime +
                ", checkinDeposit=" + checkinDeposit +
                ", checkinRoomrate=" + checkinRoomrate +
                ", vipId=" + vipId +
                ", checkinOrigin='" + checkinOrigin + '\'' +
                ", roomId=" + roomId +
                ", checkinPaytype=" + checkinPaytype +
                ", checkinRemark='" + checkinRemark + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}' + "\n";
    }
}