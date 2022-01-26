package com.sevenhome.controller;

import com.sevenhome.bean.fo.CheckinFo;
import com.sevenhome.bean.fo.SubscribeFo;
import com.sevenhome.bean.po.*;
import com.sevenhome.bean.vo.EmployeeVo;
import com.sevenhome.bean.vo.RoomVo;
import com.sevenhome.bean.vo.SubscribeDetailVo;
import com.sevenhome.bean.vo.SubscribeVoPageInfo;
import com.sevenhome.service.impl.*;
import com.sevenhome.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * fzw receptionController
 */
@RestController
public class receptionController {

    @Autowired
    private SubscribeService subscribeService;
    @Autowired
    private VipService vipService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CheckInService checkInService;
    @Autowired
    private HotelService hotelService;
    /**
     * 多条件查询预订列表
     *
     * @param pageNum
     * @param pageSize
     * @param subscribeName
     * @param subscribePhone
     * @param roomtypeId
     * @return
     */
    @GetMapping("subscribe/list")
    @PreAuthorize("hasAuthority('subscribe:list')")
    public ResponseResult<Object> showSubscribeList(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(value = "subscribeName", required = false, defaultValue = "") String subscribeName,
            @RequestParam(value = "subscribePhone", required = false, defaultValue = "") String subscribePhone,
            @RequestParam(value = "roomtypeId", required = false, defaultValue = "") Integer roomtypeId,
            @RequestParam(value = "hotelId", required = false, defaultValue = "")Integer hotelId
    ) {
        SubscribeVoPageInfo pageInfo = subscribeService.getListByCondition(
                pageNum,
                pageSize,
                subscribeName,
                subscribePhone,
                roomtypeId,
                hotelId);
        if (pageInfo != null) {
            return new ResponseResult<>(200, "ok", pageInfo);
        } else {
            return new ResponseResult<>(500, "fail");
        }
    }

    /**
     * 查询房型下拉列表
     * @return
     */
    @GetMapping("subscribe/roomTypeList")
    @PreAuthorize("hasAuthority('subscribe:roomTypeList')")
    public ResponseResult<Object> showRoomTypeList(){
        List<RoomType> roomTypeList = roomTypeService.getRoomTypeList();
        if(roomTypeList!=null){
            return new ResponseResult<>(200, "ok", roomTypeList);
        }else {
            return new ResponseResult<>(500, "fail");
        }
    }

    /**
     * 查询酒店下拉列表
     * @return
     */
    @GetMapping("subscribe/hotelList")
    @PreAuthorize("hasAuthority('subscribe:hotelList')")
    public ResponseResult<Object> showHotelList(){
        List<Hotel> hotelList = hotelService.findAllHotel();
        if(hotelList!=null){
            return new ResponseResult<>(200, "ok", hotelList);
        }else {
            return new ResponseResult<>(500, "fail");
        }
    }

    /**
     * 修改预约表状态
     * @param id
     * @return
     */
    @GetMapping("subscribe/updateStatus")
    @PreAuthorize("hasAuthority('subscribe:updateStatus')")
    public ResponseResult<Void> updateSubscribeStatus(@RequestParam("id") Integer id){
        int n = subscribeService.updateSubscribeStatus(id);
        if(n>0){
            return new ResponseResult<>(200, "ok");
        }else {
            return new ResponseResult<>(500, "fail");
        }
    }

    /**
     * 线上预订接口
     * @author fzw
     * @param subscribeFo
     * @return
     */
    @PostMapping("subscribe/addSubscribe")
    public ResponseResult<Void> addSubscribeOnline(@RequestBody SubscribeFo subscribeFo) {
        subscribeFo.setSubscribeStatus(1);
        subscribeFo.setSubscribeOrigin(1);
        Vip vip = vipService.getVipByPhone(subscribeFo.getSubscribePhone());
        if(vip!=null){
            subscribeFo.setVipId(vip.getId());
        }else {
            subscribeFo.setVipId(null);
        }
        int n = 0;
        try {
            n = ordersService.insertOrder(subscribeFo);
            if (n > 0) {
                return new ResponseResult<Void>(200, "ok");
            } else {
                return new ResponseResult<Void>(500, "fail");
            }
        } catch (Exception e) {
            return new ResponseResult<>(500, "没有该房间！");
        }
    }


    /**
     * 根据手机号查询用户vip信息
     *  @author fzw
     * @return
     */
    @GetMapping("subscribe/queryVip")
    public ResponseResult<Object> queryVip(@RequestParam("useronlinePhone") String useronlinePhone) {
        Vip vip = vipService.getVipByPhone(useronlinePhone);
        if (vip != null) {
            return new ResponseResult<>(200, "ok", vip);
        } else {
            return new ResponseResult<>(500, "fail");
        }
    }

    /**
     * 根据id查询预订详情
     * @param id
     * @return
     */
    @GetMapping("subscribe/querySubscribeDetail")
    @PreAuthorize("hasAuthority('subscribe:querySubscribeDetail')")
    public ResponseResult<Object> getSubscribeById(@RequestParam("id") Integer id){
        SubscribeDetailVo subscribeDetailVo = subscribeService.getSubscribeById(id);
        if(subscribeDetailVo!=null){
            return new ResponseResult<>(200, "ok", subscribeDetailVo);
        } else {
            return new ResponseResult<>(500, "fail");
        }
    }

    /**
     * 查询预订房间信息
     * @param roomno
     * @return
     */
    @GetMapping("subscribe/getSubscribeRoom")
    public ResponseResult<Object> getSubscribeRoom(@RequestParam("roomno") String roomno){
        RoomVo subscribeRoomVo = roomService.getSubscribeRoom(roomno);
        if(subscribeRoomVo!=null){
            return new ResponseResult<>(200, "ok",subscribeRoomVo);
        }else {
            return new ResponseResult<>(500,"fail");
        }
    }

    /**
     * 查询所有员工信息
     * @author lee
     */
    @GetMapping("checkin/getEmpList")
    @PreAuthorize("hasAuthority('checkin:getEmpList')")
    public ResponseResult<Object> findAllEmp(@RequestParam("username") String username){
        List<EmployeeVo> allEmp = employeeService.findAllEmpByHotelId(username);
        if (allEmp.size()>0){
            return new ResponseResult<>(200,"ok",allEmp);
        }else {
            return new ResponseResult<>(200,"fail");
        }
    }

    /**
     * 线下登记直接入住：添加登记表记录
     * @return
     */
    @PostMapping("checkin/insertCheckin")
    @PreAuthorize("hasAuthority('checkin:insertCheckin')")
    public ResponseResult<Object> insertCheckin(@RequestBody CheckinFo checkinFo){
        checkinFo.setCheckinOrigin("2");
        int checkinId = 0;
        try {
            checkinId = checkInService.insertCheckin(checkinFo);
            if(checkinId>0){
                return new ResponseResult<Object>(200, "ok",checkinId);
            }else {
                return new ResponseResult<>(500, "fail");
            }
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseResult<>(500, "没有该房间！");
        }
    }

    /**
     * 支付成功修改支付方式
     * @param payType
     * @param id
     * @return
     */
    @GetMapping("checkin/updatePayType")
    @PreAuthorize("hasAuthority('checkin:updatePayType')")
    public ResponseResult<Void> updateChekinPayType(@RequestParam("payType") Integer payType,@RequestParam("id") Integer id){
        int n = checkInService.updatePayType(payType, id);
        if(n>0){
            return new ResponseResult<>(200, "ok");
        }else {
            return new ResponseResult<>(500, "fail");
        }
    }

    @GetMapping("checkin/getTotal")
    @PreAuthorize("hasAuthority('checkin:getTotal')")
    public ResponseResult<Object> getTotalPrice(@RequestParam("beginTime")String beginTime,
                                              @RequestParam("endTime")String endTime,
                                              @RequestParam("deposit")String deposit,
                                              @RequestParam("subscribeRoomrate")String subscribeRoomrate,
                                                @RequestParam("vipNo") String vipNo
    ){
        System.out.println(beginTime);
        System.out.println(endTime);
        String total = null;
        try {
            total = checkInService.getTotal(beginTime, endTime, deposit, subscribeRoomrate,vipNo);
            if(total!=null){
                return new ResponseResult<Object>(200, "ok",total);
            }else {
                return new ResponseResult<>(500, "fail");
            }
        } catch (Exception e) {
            return new ResponseResult<>(500, "请输入正确的vip编号！");
        }
    }
}
