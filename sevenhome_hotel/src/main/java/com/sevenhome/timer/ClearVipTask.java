package com.sevenhome.timer;

import com.sevenhome.bean.po.Vip;
import com.sevenhome.service.impl.*;
import com.sevenhome.utils.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 何好
 * 退房定时任务
 */
@Component
public class ClearVipTask {
    @Resource
    private VipService vipService;
    private static final Logger log = LoggerFactory.getLogger(ClearVipTask.class);
    private int count = 0;
    /**
     * 每隔一个小时，清除过期vip会员
     * @return
     */
    //0 0 1 * * ?
    @Scheduled(cron="0 0 */1 * * ?")
    public ResponseResult clearRoomOn2pm(){
        Date now = new Date();
        List<Vip> allVip = vipService.getAllVip();
        for (Vip vip : allVip) {
            Date vipEndtime = vip.getVipEndtime();
            if (now.getTime()>vipEndtime.getTime()){
                vipService.freezeVip(vip.getId());
            }
        }
        return null;
    }
}
