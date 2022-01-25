package com.sevenhome.bean.fo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class VipFo implements Serializable {
    private Integer id;

    private String vipNo;

    private String vipStatus;

    private String vipRemark;

    private Integer viptypeId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date vipStarttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date vipEndtime;

    private Integer useronlineId;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Vip{" +
                "id=" + id +
                ", vipNo='" + vipNo + '\'' +
                ", vipStatus='" + vipStatus + '\'' +
                ", vipRemark='" + vipRemark + '\'' +
                ", viptypeId=" + viptypeId +
                ", vipStarttime=" + vipStarttime +
                ", vipEndtime=" + vipEndtime +
                ", useronlineId=" + useronlineId +
                '}' + "\n";
    }

}