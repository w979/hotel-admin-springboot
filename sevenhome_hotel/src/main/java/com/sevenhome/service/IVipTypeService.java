package com.sevenhome.service;

import com.sevenhome.bean.fo.VipTypeFo;
import com.sevenhome.bean.po.VipType;
import com.sevenhome.bean.vo.VipTypeVo;

import java.util.List;

public interface IVipTypeService {
    //显示所有会员类型
    public List<VipTypeVo> findVipTypeList();

    //添加会员类型
    public int saveVipType(VipTypeFo vipTypeFo);

    //修改会员类型
    public int updateViptype(VipTypeFo vipTypeFo);
}
