package com.sevenhome.controller;

import com.sevenhome.bean.fo.UserOnlineFo;
import com.sevenhome.bean.vo.UserOnlineVo;
import com.sevenhome.service.IUserOnlineService;
import com.sevenhome.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 线上账号
 */
@RestController
@RequestMapping("useronline")
public class UserOnlineController {
    @Autowired
    private IUserOnlineService userOnlineService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('useronline:add')")
    public ResponseResult<Object> addUser(@RequestBody UserOnlineFo userOnlineFo){
        int i = userOnlineService.saveUserOnline(userOnlineFo);
        if (i>0){
            return new ResponseResult<Object>(200,"注册成功",i);
        }else {
            return  new ResponseResult<Object>(500,"注册失败");
        }
    }

    /**
     * 累计消费
     * @return
     */
    @GetMapping("/accruing")
    public ResponseResult<Object> accruing(){
        List<UserOnlineVo> accruing = userOnlineService.accruing();
        System.out.println(accruing.toString());
        return new ResponseResult<>(200,"累计消费查询成功",accruing);
    }
}
