package com.sevenhome.bean.fo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UserOnlineFo implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String useronlinePhone;

    private String useronlineAvatar;

    private BigDecimal useronlineTotalpay;

    private String useronlineSex;

    private String useronlineIdcard;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "UserOnline{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", useronlinePhone='" + useronlinePhone + '\'' +
                ", useronlineAvatar='" + useronlineAvatar + '\'' +
                ", useronlineTotalpay=" + useronlineTotalpay +
                ", useronlineSex='" + useronlineSex + '\'' +
                ", useronlineIdcard='" + useronlineIdcard + '\'' +
                '}' + "\n";
    }
}