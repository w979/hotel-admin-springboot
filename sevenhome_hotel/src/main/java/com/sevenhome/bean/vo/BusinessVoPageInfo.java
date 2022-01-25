package com.sevenhome.bean.vo;

import lombok.Data;

import java.util.List;
@Data
public class BusinessVoPageInfo {
    private List<BusinessVo> roomVoList;
    private long pageNum;
    private long pageSize;
    private long pages;
    private long total;
}
