package com.sevenhome.controller;

import com.github.pagehelper.PageInfo;
import com.sevenhome.bean.fo.CheckOutFo;
import com.sevenhome.bean.vo.CheckOutRoomVo;
import com.sevenhome.bean.vo.EmployeeVo;
import com.sevenhome.service.impl.*;
import com.sevenhome.utils.ResponseResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;


/**
 * @author 何好
 */
@RestController
@RequestMapping("checkout")
public class CheckOutController {
    @Resource
    private OrdersService ordersService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private CheckOutService checkOutService;

    /**
     * 显示可选退房日期
     * 能 返回字符串集合
     * 不能 没有返回值
     * @return 返回可选的离店日期
     */
    @PostMapping("/showCancelSection")
    @PreAuthorize("hasAuthority('checkout:showCancelSection')")
    public ResponseResult showCancelSection(@RequestBody CheckOutFo checkOutFO){
        List<String> cancelSectionDates = checkOutService.getCancelSectionDates(checkOutFO);
        if(cancelSectionDates.size()<=0) {
            return new ResponseResult(500,"剩余天数不足以部分退房");
        }else {
            return new ResponseResult(200,"ok",cancelSectionDates);
        }
    }


    /**
     * 修改订单退房时间
     * @return
     */
    @PostMapping("/cancelSection")
    @PreAuthorize("hasAuthority('checkout:cancelSection')")
    public ResponseResult cancelSection(@RequestBody CheckOutFo checkOutFO){
        HashMap<String, String> map = checkOutService.cancelSection(checkOutFO);
        if (map.isEmpty()){
            return new ResponseResult(403,"修改退房日期失败");
        }else {
            return new ResponseResult(200,"修改退房日期成功",map);
        }
    }

    /**
     * 立即退房
     * @param checkOutFO
     * @return
     */
    @PostMapping("/checkOutRightNow")
    @PreAuthorize("hasAuthority('checkout:checkOutRightNow')")
    public ResponseResult checkOutRightNow(@RequestBody CheckOutFo checkOutFO){
        HashMap<String, Object> map = checkOutService.checkOutRightNow(checkOutFO);
        return new ResponseResult(200,"退房成功",map);
    }

    @GetMapping("/getRoomInUse")
    @PreAuthorize("hasAuthority('checkout:getRoomInUse')")
    public ResponseResult getRoomInUse(String username,
                                       @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "roomno",required = false,defaultValue = "") String roomno){
        EmployeeVo emp = employeeService.findEmployeeByUserName(username);
        System.out.println(emp.getHotelId());
        PageInfo<CheckOutRoomVo> leaveRoomList = ordersService.getLeaveRoomList(emp.getHotelId(), roomno, pageNum);

        return new ResponseResult(200,"ok",leaveRoomList);
    }
}
