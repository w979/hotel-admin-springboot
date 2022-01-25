package com.sevenhome.bean.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;
@Data
public class RoomStatus implements Serializable {
    private Integer id;

    private Integer roomId;

    private Integer roomstatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date roomstatusDate;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "RoomStatus{" +
                "id=" + id +
                ", roomId=" + roomId +
                ", roomstatus=" + roomstatus +
                ", roomstatusDate=" + roomstatusDate +
                '}' + "\n";
    }
}