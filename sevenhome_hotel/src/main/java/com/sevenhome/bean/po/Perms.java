package com.sevenhome.bean.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class Perms implements Serializable {
    private Integer id;
    private String permName;
    private String perCode;
    private String link;
    private Integer parentid;
    private String permType;
    private String permStatus;
    private String icon;
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Perms{" +
                "id=" + id +
                ", permName='" + permName + '\'' +
                ", perCode='" + perCode + '\'' +
                ", link='" + link + '\'' +
                ", parentid=" + parentid +
                ", permType='" + permType + '\'' +
                ", permStatus='" + permStatus + '\'' +
                ", icon='" + icon + '\'' +
                '}'+"\n";
    }
}