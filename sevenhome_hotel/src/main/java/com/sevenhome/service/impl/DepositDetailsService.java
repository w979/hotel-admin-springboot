package com.sevenhome.service.impl;

import com.sevenhome.bean.po.DepositDetail;
import com.sevenhome.dao.DepositDao;
import com.sevenhome.bean.vo.DepositDetailVo;
import com.sevenhome.dao.DepositDetailDao;
import com.sevenhome.service.IDepositDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DepositDetailsService implements IDepositDetailsService {
    @Resource
    private DepositDao depositDao;

    @Resource
    private DepositDetailDao depositDetailDao;

    /**
     * 根据订单id获得押金id，查出该订单的押金明细表
     * @param orderid
     * @return
     */
    @Override
    public List<DepositDetail> getDepositDetailListByOrderid(Integer orderid) {
        Integer depositIdByOrderid = depositDao.getDepositIdByOrderid(orderid);
        return depositDetailDao.queryAllDepositDetail(depositIdByOrderid);
        }

    /** 根据押金id查询押金明细
     * @param depositId
     * @return
     */
    @Override
    public List<DepositDetailVo> getDepositDetail(Integer depositId) {
        List<DepositDetail> depositDetailList = depositDetailDao.queryAllDepositDetail(depositId);
        List<DepositDetailVo> depositDetailVoList = new ArrayList<>();
        //po转vo
        for (DepositDetail depositDetail : depositDetailList) {
            DepositDetailVo depositDetailVo = new DepositDetailVo();
            depositDetailVo.setGoodsname(depositDetail.getRoomGoods().getRoomgoodsName());
            depositDetailVo.setGoodstype(depositDetail.getRoomGoods().getGoodstype());
            depositDetailVo.setNum(depositDetail.getDepositdetailNum());
            depositDetailVo.setPrice(depositDetail.getRoomGoods().getRoomgoodsPrice());
            BigDecimal total = depositDetailVo.getPrice().multiply(new BigDecimal(depositDetailVo.getNum()));
            depositDetailVo.setTotal(total);
            depositDetailVoList.add(depositDetailVo);
        }
        return depositDetailVoList;
    }
}
