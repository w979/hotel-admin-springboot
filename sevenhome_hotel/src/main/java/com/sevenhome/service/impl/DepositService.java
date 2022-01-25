package com.sevenhome.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sevenhome.bean.po.Deposit;
import com.sevenhome.bean.vo.DepositVo;
import com.sevenhome.dao.DepositDao;
import com.sevenhome.service.IDepositService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 押金业务类
 */
@Service
@Transactional
public class DepositService implements IDepositService {
    @Resource
    private DepositDao depositDao;

    /**
     * 押金列表+条件查询
     * @author wry
     * @date 2022/1/17 22:52
     * @param roomno
     * @param hotelid
     * @return
     */
    @Override
    public PageInfo<DepositVo> queryAllDeposit(Integer pageNum,Integer pageSize,String roomno, Integer hotelid) {
        PageHelper.startPage(pageNum, pageSize);
        //po转vo
        List<DepositVo> depositVoList = new ArrayList<>();
        List<Deposit> depositList = depositDao.queryAllDeposit(roomno, hotelid);
        PageInfo<Deposit> pageInfoDeposit = new PageInfo<>(depositList);
        for (Deposit deposit : depositList) {
            DepositVo depositVo = new DepositVo();
            depositVo.setId(deposit.getId());
            depositVo.setRoomno(deposit.getOrders().getRoom().getRommno());
            depositVo.setCheckinName(deposit.getOrders().getCheckIn().getCheckinName());
            depositVo.setMoney(deposit.getDepositTotal());
            depositVo.setStatus(deposit.getStatus());
            depositVo.setHotelId(deposit.getOrders().getRoom().getHotel().getId());
            depositVo.setHotelname(deposit.getOrders().getRoom().getHotel().getHotelName());
            depositVoList.add(depositVo);
        }
        PageInfo<DepositVo> pageInfoDepositVo = new PageInfo<>(depositVoList);
        //将 po中的分页对象转为 vo 中的分页对象
        pageInfoDepositVo.setPageNum(pageInfoDeposit.getPageNum());
        pageInfoDepositVo.setPageSize(pageInfoDeposit.getPageSize());
        pageInfoDepositVo.setPages(pageInfoDeposit.getPages());
        pageInfoDepositVo.setTotal(pageInfoDeposit.getTotal());
        return pageInfoDepositVo;
    }

    /**
     * 修改押金状态
     * @param status
     * @return
     */
    @Override
    public int updateDeposit(Integer id,String status) {
        return depositDao.updateDeposit(id, status);
    }


}
