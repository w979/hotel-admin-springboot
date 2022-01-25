package com.sevenhome.service;

import com.sevenhome.bean.fo.UserOnlineFo;
import com.sevenhome.bean.po.UserOnline;
import com.sevenhome.bean.vo.UserOnlineVo;

import java.util.List;

public interface IUserOnlineService {
    //通过手机号查询用户信息
    public UserOnline getUserOnlineByPhone(String useronlinePhone);

    //用户注册
    public int saveUserOnline(UserOnlineFo userOnlineFo);

    //修改用户信息
    public int updateUserOnline(UserOnline userOnline);

    /**
     * 累计消费
     * @return
     */
    List<UserOnlineVo> accruing();
}
