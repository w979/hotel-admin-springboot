package com.sevenhome.bean.vo;

import com.sevenhome.bean.po.CheckIn;
import com.sevenhome.bean.po.Orders;
import com.sevenhome.bean.po.RoomStatus;
import com.sevenhome.bean.po.RoomType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CheckOutRoomVo {

    private Integer roomid;

    private String roomno;

    private String checkinName;

    private String checkinIdCard;

    private String checkinPhone;

    private BigDecimal deposit;

    private BigDecimal roomrate;
}
