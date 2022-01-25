package com.sevenhome.bean.fo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckOutFo implements Serializable {
    private Integer roomno;
    private String username;
    private String updateLeaveTime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "CheckOutFo{" +
                "roomno=" + roomno +
                ", username='" + username + '\'' +
                ", updateLeaveTime='" + updateLeaveTime + '\'' +
                '}';
    }
}
