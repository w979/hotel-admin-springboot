package com.sevenhome.service;

import com.github.pagehelper.PageInfo;
import com.sevenhome.bean.po.Deposit;
import com.sevenhome.bean.vo.DepositVo;


public interface IDepositService {
    //押金列表
    PageInfo<DepositVo> queryAllDeposit(Integer pageNum, Integer pageSize, String roomno, Integer hotelid);

    //修改押金状态
    int updateDeposit(Integer id,String status);


}
