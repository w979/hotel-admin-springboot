package com.sevenhome.service;

import com.sevenhome.bean.po.DepositDetail;
import com.sevenhome.bean.vo.DepositDetailVo;

import java.util.List;

public interface IDepositDetailsService {
    List<DepositDetail> getDepositDetailListByOrderid(Integer orderid);
    /**
     * 根据id押金查询订单明细
     */
    List<DepositDetailVo> getDepositDetail(Integer depositId);
}
