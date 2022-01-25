package com.sevenhome.service;

import com.sevenhome.bean.po.Business;
import com.sevenhome.bean.vo.BusinessVo;
import com.sevenhome.bean.vo.BusinessVoPageInfo;

import java.util.List;

public interface IBusinessService {

    /**
     * 查询待清房列表
     * @return
     */

    BusinessVoPageInfo findundeterminedClear(Integer pageNum, Integer pageSize);

    /**
     * 批量添加
     * @param split
     * @param id
     * @return
     */
    int batchAdd(String[] split, Integer id);

    /**
     * 删除清退房
     * @param bid
     * @return
     */
    int del(String bid);

    /**
     * 添加清房事务
     * @param id
     * @return
     */
    int addBussiness(Integer id);
}
