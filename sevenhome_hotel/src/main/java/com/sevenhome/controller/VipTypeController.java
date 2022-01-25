package com.sevenhome.controller;

import com.sevenhome.bean.fo.VipTypeFo;
import com.sevenhome.bean.po.VipType;
import com.sevenhome.bean.vo.VipTypeVo;
import com.sevenhome.service.IVipTypeService;
import com.sevenhome.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员类型请求
 */
@RestController
@RequestMapping("viptype")
public class VipTypeController {

    @Autowired
    private IVipTypeService vipTypeService;

    /**
     * 显示会员类型
     * @return
     */
    @GetMapping ("/list")
    @PreAuthorize("hasAuthority('viptype:list')")
    public ResponseResult<Object> showList(){
        List<VipTypeVo> vipTypeVoList = vipTypeService.findVipTypeList();
        if (vipTypeVoList.size()>0){
            return new ResponseResult<Object>(200,"ok",vipTypeVoList);
        }else {
            return new ResponseResult<Object>(500, "会员类型列表加载失败");
        }
    }

    /**
     * 添加会员类型
     * @param vipTypeFo
     * @return
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('viptype:add')")
    public ResponseResult<Void> addVipType(@RequestBody VipTypeFo vipTypeFo){
        int n = vipTypeService.saveVipType(vipTypeFo);
        if (n>0){
            return new ResponseResult<Void>(200,"ok");
        }else {
            return new ResponseResult<Void>(500,"会员类型添加失败");
        }
    }


    /**
     * 会员类型修改
     * @param vipTypeFo
     * @return
     */
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('viptype:update')")
    public ResponseResult<Void> updateType(@RequestBody VipTypeFo vipTypeFo){
        int n = vipTypeService.updateViptype(vipTypeFo);
        if (n>0){
            return new ResponseResult<Void>(200,"ok");
        }else {
            return new ResponseResult<Void>(500,"会员类型修改失败");
        }
    }
}
