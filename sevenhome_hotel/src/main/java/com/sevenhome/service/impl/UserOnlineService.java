package com.sevenhome.service.impl;

import com.sevenhome.bean.fo.UserOnlineFo;
import com.sevenhome.bean.po.UserOnline;
import com.sevenhome.bean.vo.UserOnlineVo;
import com.sevenhome.dao.UserOnlineDao;
import com.sevenhome.service.IUserOnlineService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserOnlineService implements IUserOnlineService {
    @Resource
    private UserOnlineDao userOnlineDao;

    /**
     * 通过手机号查询用户信息
     * @param useronlinePhone
     * @return
     */
    @Override
    public UserOnline getUserOnlineByPhone(String useronlinePhone) {
        return userOnlineDao.getUserOnlineByPhone(useronlinePhone);
    }

    /**
     * 注册用户
     * @param userOnlineFo
     * @return 注册用户的id
     */
    @Override
    public int saveUserOnline(UserOnlineFo userOnlineFo) {
        UserOnline userOnline = new UserOnline();
        BeanUtils.copyProperties(userOnlineFo, userOnline);
        int n = userOnlineDao.insertSelective(userOnline);
        return userOnline.getId();
    }

    /**
     * 修改用户信息
     * @param userOnline
     * @return
     */
    @Override
    public int updateUserOnline(UserOnline userOnline) {
        return userOnlineDao.updateByPrimaryKeySelective(userOnline);
    }

    /**
     * 累计消费
     * @return
     */
    @Override
    public List<UserOnlineVo> accruing() {
        List<UserOnline> accruing = userOnlineDao.accruing();
        ArrayList<UserOnlineVo> userOnlines = new ArrayList<>();
        for (UserOnline userOnline : accruing){
            UserOnlineVo userOnlineVo = new UserOnlineVo();
            userOnlineVo.setUsername(userOnline.getUsername());
            userOnlineVo.setUseronlineTotalpay(userOnline.getUseronlineTotalpay());
            userOnlines.add(userOnlineVo);
        }
        return userOnlines;
    }
}
