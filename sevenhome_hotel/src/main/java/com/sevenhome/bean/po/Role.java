package com.sevenhome.bean.po;

import lombok.Data;

import java.io.Serializable;
import javax.annotation.Generated;
@Data
public class Role implements Serializable {

    private Integer id;

    private String rname;

    private String rcode;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rname='" + rname + '\'' +
                ", rcode='" + rcode + '\'' +
                '}'+"\n";
    }
}