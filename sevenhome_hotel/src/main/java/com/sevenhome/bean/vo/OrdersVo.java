package com.sevenhome.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单列表Vo
 */
@Data
public class OrdersVo {
    private String orderno;     //订单编号

    private String subscibeName;    //预约人

    private String phone;   //联系电话

    private String roomno; //房间号

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date newtime;   //预约时间  当前系统时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date intime;    //入住时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date leavetime; //离开时间

    private BigDecimal roomrate; //价格

    private Integer origin;  //预约方式   线上/线下

    private String status;  //状态    已支付/已取消

    private Integer hotelid; //所属酒店
    
    private String hotelname; //所属酒店

    private Integer id;
    @Override
    public String toString() {
        return "OrdersVo{" +
                "orderno='" + orderno + '\'' +
                ", subscibeName='" + subscibeName + '\'' +
                ", phone='" + phone + '\'' +
                ", roomno='" + roomno + '\'' +
                ", newtime=" + newtime +
                ", intime=" + intime +
                ", leavetime=" + leavetime +
                ", roomrate=" + roomrate +
                ", origin='" + origin + '\'' +
                ", status='" + status + '\'' +
                ", hotelid=" + hotelid +
                ", hotelname=" + hotelname +
                '}'+"\n";
    }
}
