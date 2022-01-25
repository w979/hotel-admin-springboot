package com.sevenhome.controller;

import com.sevenhome.bean.po.Room;
import com.sevenhome.bean.vo.RoomVo;
import com.sevenhome.bean.vo.RoomVoPageInfo;
import com.sevenhome.service.IRoomService;
import com.sevenhome.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * lee
 */
@RestController
public class RoomController {

    @Autowired
    private IRoomService iRoomService;

    /**
     * 房态
     * @param username 登陆人的username
     * @return
     */
    @GetMapping("room/roomStatus")
    @PreAuthorize("hasAuthority('room:roomStatus')")
    public ResponseResult<Object> roomStatusTbale(@RequestParam("username") String username, String today,
                                                  @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                                  @RequestParam(value = "pageSize",required = false,defaultValue = "12") Integer pageSize) throws ParseException {

        System.out.println("开始时间"+today);
        System.out.println(pageNum);
        System.out.println(pageSize);
        //如果前端没有日期则默认使用当天的日期查询当日房态，如果传值了则转换查大于等于值日期的房态
        if (today=="" || today == null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String format = simpleDateFormat.format(date);
            today = format;
        }else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(today);
            String format = simpleDateFormat.format(parse);
            today = format;
        }
        RoomVoPageInfo roomVoPageInfo = iRoomService.roomStatusTbale(username,today, pageNum, pageSize);
        System.out.println("查询出的数据是："+roomVoPageInfo.toString());
        return new ResponseResult<>(200,"查询房态成功",roomVoPageInfo);
    }


}
