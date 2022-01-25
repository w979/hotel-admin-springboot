package com.sevenhome.bean.vo;

import lombok.Data;

import java.util.List;

/**
 * subscribe自定义PageInfo类
 */
@Data
public class SubscribeVoPageInfo {
    private List<SubscribeVo> subscribeVoList;
    private long pageNum;
    private long pageSize;
    private long pages;
    private long total;
}
