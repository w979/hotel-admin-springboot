package com.sevenhome.controller;

import com.github.pagehelper.PageInfo;
import com.sevenhome.bean.fo.VipFo;
import com.sevenhome.bean.po.UserOnline;
import com.sevenhome.bean.vo.VipDetailVo;
import com.sevenhome.bean.vo.VipTypeVo;
import com.sevenhome.bean.vo.VipVo;
import com.sevenhome.service.IUserOnlineService;
import com.sevenhome.service.IVipService;
import com.sevenhome.service.IVipTypeService;
import com.sevenhome.utils.RandomCode;
import com.sevenhome.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 会员
 */
@RestController
@RequestMapping("vip")
public class VipController {

    @Autowired
    private IVipService vipService;

    @Autowired
    private IUserOnlineService userOnlineService;

    @Autowired
    private IVipTypeService vipTypeService;

    /**
     * 检查手机号的用户状态
     *
     * @param phone
     * @return
     */
    @GetMapping("/check")
    @PreAuthorize("hasAuthority('vip:check')")
    public ResponseResult<Object> checkPhone(@RequestParam("phone") String phone) {
        int isVipByPhone = vipService.getIsVipByPhone(phone);
        if (isVipByPhone == 1) {
            return new ResponseResult<Object>(2001, "手机号还未注册账号");
        } else if (isVipByPhone == 2) {
            UserOnline userOnlineByPhone = userOnlineService.getUserOnlineByPhone(phone);
            return new ResponseResult<Object>(2002, "手机号已注册账号，可以办理vip", userOnlineByPhone.getId());
        } else if (isVipByPhone == 3) {
            return new ResponseResult<Object>(2003, "手机用户已是vip，无需办理");
        } else {
            return new ResponseResult<Object>(500, "查询vip出错");
        }
    }

    /**
     * 会员办理
     *
     * @return
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('vip:add')")
    public ResponseResult<Void> addVip(@RequestBody VipFo vipFo) {
        vipFo.setVipStarttime(new Date());
        vipFo.setVipNo(RandomCode.getVipNo(vipFo.getVipNo()));
        int n = vipService.saveVip(vipFo);
        if (n > 0) {
            return new ResponseResult<Void>(200, "办理成功");
        } else {
            return new ResponseResult<Void>(500, "办理失败");
        }
    }

    /**
     * 显示会员列表信息
     * @param pageNo
     * @param pageSize
     * @param viptypeId
     * @param vipStatus
     * @param phone
     * @param username
     * @param idCard
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('vip:list')")
    public ResponseResult<Object> showList(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                           @RequestParam(value = "viptypeId", required = false, defaultValue = "") Integer viptypeId,
                                           @RequestParam(value = "vipStatus", required = false, defaultValue = "") String vipStatus,
                                           @RequestParam(value = "phone", required = false, defaultValue = "") String phone,
                                           @RequestParam(value = "username", required = false, defaultValue = "") String username,
                                           @RequestParam(value = "idCard", required = false, defaultValue = "") String idCard) {
        List<VipTypeVo> vipTypeList = vipTypeService.findVipTypeList();
        PageInfo<VipVo> vipVoList = vipService.findVipVoList(pageNo, pageSize, viptypeId, vipStatus, phone, username, idCard);
        Map map = new HashMap();
        map.put("vipVoList", vipVoList);
        map.put("vipTypeList",vipTypeList);
        if (vipVoList.getList().size() >= 0) {
            return new ResponseResult<Object>(200, "ok", map);
        }
        return new ResponseResult<Object>(500,"会员列表显示失败");
    }

    /**
     * 查询VIP详情
     * @param id
     * @return
     */
    @GetMapping("/detail")
    @PreAuthorize("hasAuthority('vip:detail')")
    public ResponseResult<Object> showDetail(@RequestParam("id") Integer id){
        VipDetailVo vip = vipService.getVipById(id);
        if (vip!=null){
            return new ResponseResult<Object>(200,"ok",vip);
        }else {
            return new ResponseResult<Object>(500,"显示详细信息错误");
        }
    }

    /**
     * 会员信息修改
     * @param detailVo
     * @return
     */
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('vip:update')")
    public ResponseResult<Void> updateVip(@RequestBody VipDetailVo detailVo){
        int n = vipService.updateVip(detailVo);
        if (n>0){
            return new ResponseResult<Void>(200,"ok");
        }else {
            return new ResponseResult<Void>(500,"修改会员信息错误");
        }
    }

    /**
     * 冻结会员
     * @param id
     * @return
     */
    @GetMapping("/freeze")
    @PreAuthorize("hasAuthority('vip:freeze')")
    public ResponseResult<Void> freezeVip(@RequestParam("id") Integer id){
        int n = vipService.freezeVip(id);
        if (n>0){
            return new ResponseResult<Void>(200,"ok");
        }else {
            return new ResponseResult<Void>(500,"冻结会员信息错误");
        }
    }

    /**
     * 激活会员
     * @param id
     * @return
     */
    @GetMapping("/activate")
    @PreAuthorize("hasAuthority('vip:activate')")
    public ResponseResult<Void> activateVip(@RequestParam("id") Integer id){
        int n = vipService.activateVip(id);
        if (n>0){
            return new ResponseResult<Void>(200,"ok");
        }else {
            return new ResponseResult<Void>(500,"激活会员信息错误");
        }
    }

}
