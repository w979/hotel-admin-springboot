package com.sevenhome.bean.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
@Data
public class Orders implements Serializable {
    private Integer id;

    private String orderno;

    private Integer subscribeId;

    private Integer checkinId;

    private BigDecimal orderTotalprice;

    private String orderStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderGeneratetime;

    private Integer roomId;

    private Room room;

    private Subscribe subscribe;

    private CheckIn checkIn;

    private Deposit deposit;

    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderno='" + orderno + '\'' +
                ", subscribeId=" + subscribeId +
                ", checkinId=" + checkinId +
                ", orderTotalprice=" + orderTotalprice +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderGeneratetime=" + orderGeneratetime +
                ", roomId=" + roomId +
                ", checkIn=" + checkIn +
                ", subscribe=" + subscribe +
                '}';
    }
}