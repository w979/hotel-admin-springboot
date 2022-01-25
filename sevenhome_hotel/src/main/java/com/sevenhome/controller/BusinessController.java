package com.sevenhome.controller;

import com.sevenhome.bean.po.Business;
import com.sevenhome.bean.vo.BusinessVo;
import com.sevenhome.bean.vo.BusinessVoPageInfo;
import com.sevenhome.service.IBusinessService;
import com.sevenhome.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * lee
 * 客房部
 */
@RestController
@RequestMapping("business")
public class BusinessController {

    @Autowired
    private IBusinessService iBusinessService;

    /**
     * 待清房列表
     */
    @GetMapping("/findundeterminedClear")
    @PreAuthorize("hasAuthority('business:findundeterminedClear')")
    public ResponseResult<Object> findundeterminedClear(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize",required = false,defaultValue = "4")Integer pageSize){
        System.out.println(pageNum);
        System.out.println(pageSize);
        BusinessVoPageInfo aaa = iBusinessService.findundeterminedClear(pageNum, pageSize);
        System.out.println("查出的数据是:"+aaa.toString());
        return new ResponseResult<>(200,"查询待清房列表成功",aaa);
    }

    /**
     * 批量添加
     */
    @GetMapping("/batchAdd")
    @PreAuthorize("hasAuthority('business:batchAdd')")
    public ResponseResult<Void> batchAdd(@RequestParam("goodId") String goodId,Integer id,Integer bid){
        System.out.println(goodId);
        String[] split = goodId.split(",");
        int i = iBusinessService.batchAdd(split, id);
        if (i>0){
            System.out.println("添加成功！");
//            int del = iBusinessService.del(bid);
            return new ResponseResult<>(200,"批量添加成功！");
        }else {
            return new ResponseResult<>(500,"批量添加失败！");
        }
    }
}
