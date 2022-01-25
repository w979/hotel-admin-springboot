package com.sevenhome.service;

import com.github.pagehelper.PageInfo;
import com.sevenhome.bean.fo.VipFo;
import com.sevenhome.bean.po.Vip;
import com.sevenhome.bean.vo.VipDetailVo;
import com.sevenhome.bean.vo.VipVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IVipService {

    /**
     * 根据手机号查询该用户vip信息
     *
     * @param useronlinePhone
     * @return
     */
    Vip getVipByPhone(String useronlinePhone);

    /**
     * 通过手机号查询用户状态
     *
     * @param useronlinePhone
     * @return
     */
    public int getIsVipByPhone(String useronlinePhone);

    /**
     * 办理vip
     *
     * @param vipFo
     * @return
     */
    public int saveVip(VipFo vipFo);

    /**
     * 多条件显示vip列表
     *
     * @param pageNo
     * @param pageSize
     * @param viptypeId
     * @param vipStatus
     * @param phone
     * @param username
     * @param idCard
     * @return
     */
    public PageInfo<VipVo> findVipVoList(Integer pageNo, Integer pageSize, Integer viptypeId, String vipStatus,
                                         String phone, String username, String idCard);

    /**
     * 通过id获得会员详细信息
     *
     * @param id
     * @return
     */
    public VipDetailVo getVipById(Integer id);

    /**
     * 修改会员信息
     * @param vipDetailVo
     * @return
     */
    public int updateVip(VipDetailVo vipDetailVo);


    /**
     * 冻结当前会员
     * @param id
     * @return
     */
    public int freezeVip(Integer id);

    /**
     * 激活当前会员
     * @param id
     * @return
     */
    public int activateVip(Integer id);

    /**
     * 删除当前会员
     * @param id
     * @return
     */
    public int deleteVip(Integer id);


    /**
     * 获得全部vip会员
     * @return
     */
    List<Vip> getAllVip();
}
