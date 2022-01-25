package com.sevenhome.bean.fo;

import lombok.Data;

import java.io.Serializable;

@Data
public class VipTypeFo implements Serializable {
    private Integer id;

    private String viptypeName;

    private String viptypeLevel;

    private String viptypeDiscount;

    private String viptypeStep;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "VipType{" +
                "id=" + id +
                ", viptypeName='" + viptypeName + '\'' +
                ", viptypeLevel='" + viptypeLevel + '\'' +
                ", viptypeDiscount='" + viptypeDiscount + '\'' +
                ", viptypeStep='" + viptypeStep + '\'' +
                '}' + "\n";
    }
}
