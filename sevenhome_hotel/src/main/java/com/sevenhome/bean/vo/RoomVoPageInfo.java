package com.sevenhome.bean.vo;

import lombok.Data;

import java.util.List;
@Data
public class RoomVoPageInfo {
    private List<RoomVo> roomVoList;
    private long pageNum;
    private long pageSize;
    private long pages;
    private long total;
}
