package com.sevenhome.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sevenhome.bean.fo.SubscribeFo;
import com.sevenhome.bean.po.Subscribe;
import com.sevenhome.bean.vo.SubscribeDetailVo;
import com.sevenhome.bean.vo.SubscribeVo;
import com.sevenhome.bean.vo.SubscribeVoPageInfo;
import com.sevenhome.dao.SubscribeDao;
import com.sevenhome.service.ISubscribeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SubscribeService implements ISubscribeService {
    @Autowired
    SubscribeDao subscribeDao;


    /**
     * 根据条件查询预定表信息
     * @param pageNum
     * @param pageSize
     * @param subscribeName
     * @param subscribePhone
     * @param roomtypeId
     * @return
     */
    @Override
    public SubscribeVoPageInfo getListByCondition(Integer pageNum,
                                                  Integer pageSize,
                                                  String subscribeName,
                                                  String subscribePhone,
                                                  Integer roomtypeId,
                                                  Integer hotelId) {
        PageHelper.startPage(pageNum,pageSize);
        List<Subscribe> subscribeList = subscribeDao.getListByCondition(subscribeName, subscribePhone, roomtypeId , hotelId);
        PageInfo<Subscribe> subscribePageInfo = new PageInfo<>(subscribeList);

        //将po对象转为vo对象
        List<SubscribeVo> subscribeVoList = new ArrayList<>();
        for (Subscribe subscribe:subscribeList) {
            SubscribeVo subscribeVo = new SubscribeVo();
            subscribeVo.setId(subscribe.getId());
            subscribeVo.setSubscribeName(subscribe.getSubscribeName());
            subscribeVo.setSubscribePhone(subscribe.getSubscribePhone());
            subscribeVo.setSubscribeIntime(subscribe.getSubscribeIntime());
            subscribeVo.setSubscribeLeavetime(subscribe.getSubscribeLeavetime());
            subscribeVo.setSubscribeStatus(subscribe.getSubscribeStatus());
            subscribeVo.setSubscribePaytype(subscribe.getSubscribePaytype());
            subscribeVo.setRoomTypeName(subscribe.getRoomType().getRoomtypeName());
            subscribeVo.setEmployeeName(subscribe.getEmployee().getEmpname());
            subscribeVo.setEmployeeId(subscribe.getEmployee().getId());
            subscribeVo.setSubscribeDeposit(subscribe.getSubscribeDeposit());
            subscribeVo.setSubscribeRoomrate(subscribe.getSubscribeRoomrate());
            subscribeVoList.add(subscribeVo);
        }
        //对象转换中，pageinfo中数据会丢失，所以在这里对paginfo中的数据做转换处理
        SubscribeVoPageInfo pageInfo = new SubscribeVoPageInfo();
        pageInfo.setPageNum(subscribePageInfo.getPageNum());
        pageInfo.setPageSize(subscribePageInfo.getPageSize());
        pageInfo.setPages(subscribePageInfo.getPages());
        pageInfo.setTotal(subscribePageInfo.getTotal());
        pageInfo.setSubscribeVoList(subscribeVoList);

        System.out.println(pageInfo.getSubscribeVoList());
        return pageInfo;
    }

    /**
     * 更新预约表离店时间
     * @param id
     * @param leaveTime
     * @return
     */
    @Override
    public int updateLeaveTime(Integer id, Date leaveTime, BigDecimal money) {
        return subscribeDao.updateLeaveTime(id,leaveTime,money);
    }

    /**
     * 修改预约表状态
     * @param id
     * @return
     */
    @Override
    public int updateSubscribeStatus(Integer id) {
        return subscribeDao.updateSubscribeStatus(id);
    }

    /**
     * 根据id查询预订详情
     * @param id
     * @return
     */
    @Override
    public SubscribeDetailVo getSubscribeById(Integer id) {
        Subscribe subscribe = subscribeDao.getSubscribeById(id);
        SubscribeDetailVo subscribeDetailVo = new SubscribeDetailVo();
        BeanUtils.copyProperties(subscribe, subscribeDetailVo);
        return subscribeDetailVo;
    }

}