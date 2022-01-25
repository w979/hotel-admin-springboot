package com.sevenhome.service.impl;

import com.sevenhome.bean.fo.VipTypeFo;
import com.sevenhome.bean.po.VipType;
import com.sevenhome.bean.vo.VipTypeVo;
import com.sevenhome.dao.VipTypeDao;
import com.sevenhome.service.IVipTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VipTypeService implements IVipTypeService {
    @Resource
    private VipTypeDao vipTypeDao;

    /**
     * 会员类型查询
     * @return
     */
    @Override
    public List<VipTypeVo> findVipTypeList() {
        List<VipType> vipTypeList = vipTypeDao.selectVipTypList();
        List<VipTypeVo> vipTypeVoList = new ArrayList<>();
        for (VipType viptype : vipTypeList) {
            VipTypeVo vipTypeVo = new VipTypeVo();
            BeanUtils.copyProperties(viptype, vipTypeVo);
            vipTypeVoList.add(vipTypeVo);
        }
        return vipTypeVoList;
    }

    /**
     * 会员类型添加
     * @param vipTypeFo
     * @return
     */
    @Override
    public int saveVipType(VipTypeFo vipTypeFo) {
        VipType vipType = new VipType();
        BeanUtils.copyProperties(vipTypeFo,vipType);
        return vipTypeDao.insertSelective(vipType);
    }

    /**
     * 会员类型修改
     * @param vipTypeFo
     * @return
     */
    @Override
    public int updateViptype(VipTypeFo vipTypeFo) {
        VipType vipType = new VipType();
        BeanUtils.copyProperties(vipTypeFo,vipType);
        return vipTypeDao.updateByPrimaryKeySelective(vipType);
    }


}
