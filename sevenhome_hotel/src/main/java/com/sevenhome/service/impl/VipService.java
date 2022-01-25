package com.sevenhome.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sevenhome.bean.fo.VipFo;
import com.sevenhome.bean.po.UserOnline;
import com.sevenhome.bean.po.Vip;
import com.sevenhome.bean.vo.VipDetailVo;
import com.sevenhome.bean.vo.VipVo;
import com.sevenhome.dao.VipDao;
import com.sevenhome.service.IVipService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VipService implements IVipService {

    @Autowired
    private VipDao vipDao;

    @Autowired
    private UserOnlineService userOnlineService;

    /**
     * 根据手机号查询该用户vip信息
     *
     * @param useronlinePhone
     * @return
     */
    @Override
    public Vip getVipByPhone(String useronlinePhone) {
        return vipDao.getVip(useronlinePhone);
    }

    /**
     * 通过手机号获得手机号是否注册过vip
     *
     * @param useronlinePhone
     * @return 1：手机号未创建账号 2：手机号创建过账号，但不是vip 3：手机号既创建了账号也是vip
     */
    @Override
    public int getIsVipByPhone(String useronlinePhone) {
        int state = -1;
        UserOnline userOnlineByPhone = userOnlineService.getUserOnlineByPhone(useronlinePhone);
        if (userOnlineByPhone == null) {
            state = 1;
        } else {
            Vip vip = vipDao.getVipByUserId(userOnlineByPhone.getId());
            if (vip == null) {
                state = 2;
            } else  {
                state = 3;
            }
        }
        return state;
    }

    /**
     * VIP办理
     * @param vipFo
     * @return
     */
    @Override
    public int saveVip(VipFo vipFo) {
        Vip vip = new Vip();
        BeanUtils.copyProperties(vipFo, vip);
        return vipDao.insertSelective(vip);
    }

    /**
     * 分页显示会员列表信息
     * @param pageNo
     * @param pageSize
     * @param viptypeId
     * @param vipStatus
     * @param phone
     * @param username
     * @param idCard
     * @return
     */
    @Override
    public PageInfo<VipVo> findVipVoList(Integer pageNo, Integer pageSize, Integer viptypeId,
                                     String vipStatus, String phone, String username, String idCard) {
        PageHelper.startPage(pageNo, pageSize);
        List<Vip> vipList = vipDao.selectVipListByQuery(viptypeId, vipStatus, phone, username, idCard);
        PageInfo<Vip> vipPageInfo = new PageInfo<>(vipList);
        List<VipVo> vipVoList =new ArrayList<>();
        for (Vip vip: vipList) {
            if (vip.getUserOnline()==null){
                continue;//如果不是VIP就跳过
            }
            VipVo vipVo =new VipVo();
            vipVo.setId(vip.getId());
            vipVo.setVipNo(vip.getVipNo());
            vipVo.setVipStatus(vip.getVipStatus());
            vipVo.setUseronlineTotalpay(vip.getUserOnline().getUseronlineTotalpay());
            vipVo.setUsername(vip.getUserOnline().getUsername());
            vipVo.setViptypeId(vip.getViptypeId());
            vipVoList.add(vipVo);
        }
        //创建vo以象的分页对象
        PageInfo<VipVo> vipVoPageInfo = new PageInfo<>(vipVoList);
        //将po的分数据转为vo的分页数据
        BeanUtils.copyProperties(vipPageInfo, vipVoPageInfo);
        //将分页对象中的数据转为vo集合
        vipVoPageInfo.setList(vipVoList);
        return vipVoPageInfo;
    }

    /**
     * 通过id显示会员详细信息
     * @param id
     * @return
     */
    @Override
    public VipDetailVo getVipById(Integer id) {
        Vip vip = vipDao.selectVipById(id);
        VipDetailVo detailVo = new VipDetailVo();
        detailVo.setId(vip.getId());
        detailVo.setVipNo(vip.getVipNo());
        detailVo.setVipEndtime(vip.getVipEndtime());
        detailVo.setVipStarttime(vip.getVipStarttime());
        detailVo.setVipStatus(vip.getVipStatus());
        detailVo.setVipRemark(vip.getVipRemark());
        detailVo.setUseronlineId(vip.getUserOnline().getId());
        detailVo.setUseronlineTotalpay(vip.getUserOnline().getUseronlineTotalpay());
        detailVo.setUsername(vip.getUserOnline().getUsername());
        detailVo.setPassword(vip.getUserOnline().getPassword());
        detailVo.setUseronlinePhone(vip.getUserOnline().getUseronlinePhone());
        detailVo.setUseronlineSex(vip.getUserOnline().getUseronlineSex());
        detailVo.setUseronlineIdcard(vip.getUserOnline().getUseronlineIdcard());
        detailVo.setViptypeName(vip.getVipType().getViptypeName());
        return detailVo;
    }

    /**
     * 修改会员信息
     * @param vipDetailVo
     * @return
     */
    @Override
    public int updateVip(VipDetailVo vipDetailVo) {
        Vip vip = new Vip();
        vip.setId(vipDetailVo.getId());
        vip.setVipEndtime(vipDetailVo.getVipEndtime());
        vip.setVipRemark(vipDetailVo.getVipRemark());
        int n1 = vipDao.updateByPrimaryKeySelective(vip);
        UserOnline userOnline = new UserOnline();
        userOnline.setId(vipDetailVo.getUseronlineId());
        System.out.println(userOnline.getId());
        userOnline.setUsername(vipDetailVo.getUsername());
        userOnline.setPassword(vipDetailVo.getPassword());
        userOnline.setUseronlineSex(vipDetailVo.getUseronlineSex());
        userOnline.setUseronlinePhone(vipDetailVo.getUseronlinePhone());
        userOnline.setUseronlineTotalpay(vipDetailVo.getUseronlineTotalpay());
        int n2 = userOnlineService.updateUserOnline(userOnline);
        if (n1>0&&n2>0){
            return 1;
        }
        return -1;
    }

    /**
     * 冻结会员
     * @param id
     * @return
     */
    @Override
    public int freezeVip(Integer id) {
        return vipDao.freezeVip(id);
    }

    /**
     * 激活当前会员
     * @param id
     * @return
     */
    @Override
    public int activateVip(Integer id) {
        return vipDao.activateVip(id);
    }

    /**
     * 删除当前会员
     * @param id
     * @return
     */
    @Override
    public int deleteVip(Integer id) {
        return vipDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Vip> getAllVip() {
        return vipDao.select(c->c);
    }


}
