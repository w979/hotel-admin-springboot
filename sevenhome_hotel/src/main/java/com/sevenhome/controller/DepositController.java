package com.sevenhome.controller;

import com.github.pagehelper.PageInfo;
import com.sevenhome.bean.vo.DepositDetailVo;
import com.sevenhome.bean.vo.DepositVo;
import com.sevenhome.service.IDepositDetailsService;
import com.sevenhome.service.IDepositService;
import com.sevenhome.utils.ResponseResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DepositController {

    @Resource
    private IDepositService depositService;

    @Resource
    private IDepositDetailsService depositDetailsService;

    /**
     * 押金列表 +条件查询
     *  @author wry
     *  @date 2022/1/17 21:13
     * @param pageNum
     * @param pageSize
     * @param roomno
     * @param hotelid
     * @return
     */
    @GetMapping("deposit/list")
    @PreAuthorize("hasAuthority('deposit:list')")
    public ResponseResult<Object> queryAllOrders(@RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
                                                 @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize,
                                                 @RequestParam(value = "roomno",required = false,defaultValue = "") String  roomno,
                                                     @RequestParam(value = "hotelid",required = false,defaultValue = "") Integer hotelid){
        PageInfo<DepositVo> pageInfo = depositService.queryAllDeposit(pageNum, pageSize, roomno, hotelid);
        return new ResponseResult<>(200, "押金列表",pageInfo);
    }


    /**
     * 根据押金id查询押金明细
     * @author wry
     * @date 2022/1/18 11:43
     * @param depositId
     * @return
     */
    @GetMapping("deposit/detail")
    @PreAuthorize("hasAuthority('deposit:detail')")
    public ResponseResult<Object> queryDepositDetail(@RequestParam(value = "depositId",required = false,defaultValue = "") Integer depositId){
        List<DepositDetailVo> depositDetailVoList = depositDetailsService.getDepositDetail(depositId);
         //计算总计消费
        BigDecimal finalTotal = new BigDecimal(0);
        for (DepositDetailVo depositDetailVo : depositDetailVoList) {
           finalTotal = finalTotal.add(depositDetailVo.getTotal());
        }

        Map<String,Object> map = new HashMap<>();
        map.put("depositDetailVoList",depositDetailVoList);
        map.put("finalTotal",finalTotal);

        if (depositDetailVoList.size() >0 ){
            return new ResponseResult<>(200, "消费明细",map);
        }else {
            return new ResponseResult<>(201, "没有产生额外消费");
        }
    }

    /**
     * 修改押金状态
     * @param id
     * @param status
     * @return
     */
    @GetMapping("deposit/update")
    @PreAuthorize("hasAuthority('deposit:update')")
    public ResponseResult<Void> updateDeposit(@RequestParam(value = "id",required = false,defaultValue = "") Integer id,
                                                @RequestParam(value = "status",required = false,defaultValue = "") String status){
        int n = depositService.updateDeposit(id, status);
        if (n > 0){
            return new ResponseResult<>(200, "押金状态修改成功");
        }else {
            return new ResponseResult<>(501, "押金状态修改失败");
        }
    }
}
