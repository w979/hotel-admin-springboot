package com.sevenhome.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sevenhome.bean.po.Business;
import com.sevenhome.bean.po.DepositDetail;
import com.sevenhome.bean.po.Orders;
import com.sevenhome.bean.po.RoomGoods;
import com.sevenhome.bean.vo.BusinessVo;
import com.sevenhome.bean.vo.BusinessVoPageInfo;
import com.sevenhome.dao.*;
import com.sevenhome.service.IBusinessService;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;


@Service
public class BusinessService implements IBusinessService {

    @Autowired
    private BusinessDao businessDao;

    @Autowired
    private DepositDetailDao depositDetailDao;

    /**
     * 查询待清房列表
     * @return
     */
    @Override
    public BusinessVoPageInfo findundeterminedClear(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Business> businesses = businessDao.findundeterminedClear();
        System.out.println("分页后的数据是="+businesses.toString());
        PageInfo<Business> businessPageInfo = new PageInfo<>(businesses);
        ArrayList<BusinessVo> businessVos = new ArrayList<>();


        for (Business business : businesses){
            BusinessVo businessVo = new BusinessVo();
            businessVo.setOrderno(business.getOrders().getOrderno());
            businessVo.setRommno(business.getOrders().getRoom().getRommno());
            businessVo.setRoomFloor(business.getOrders().getRoom().getRoomFloor());
            businessVo.setRoomStatus(business.getOrders().getRoom().getRoomStatus());
            businessVo.setDepositId(business.getOrders().getDeposit().getId());
            businessVos.add(businessVo);
        }

        //对象转换中，pageinfo中数据会丢失，所以在这里对paginfo中的数据做转换处理
        BusinessVoPageInfo pageInfo = new BusinessVoPageInfo();
        pageInfo.setPageNum(businessPageInfo.getPageNum());
        pageInfo.setPageSize(businessPageInfo.getPageSize());
        pageInfo.setPages(businessPageInfo.getPages());
        pageInfo.setTotal(businessPageInfo.getTotal());
        pageInfo.setRoomVoList(businessVos);
        return pageInfo;
    }

    @Override
    public int batchAdd(String[] split, Integer id) {
        /**
         * String数组转int数组
         */
        int[] intTemp = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            intTemp[i] = Integer.parseInt(split[i]);
            System.out.println(intTemp[i]);
        }
        /**
         * 批量添加
         */
        int n = 0;
        DepositDetail depositDetail = null;
        for (int i = 0; i < intTemp.length; i++) {
            depositDetail = new DepositDetail();
            depositDetail.setRoomgoodsId(intTemp[i]);
            depositDetail.setDepositdetailNum(1);
            depositDetail.setDepositId(id);
            depositDetailDao.insert(depositDetail);
            n++;
        }
        return n;
    }

    @Override
    public int del(String bid) {
        DeleteStatementProvider statementProvider = SqlBuilder
                .deleteFrom(OrdersDynamicSqlSupport.orders)
                .where(OrdersDynamicSqlSupport.orderno,isEqualTo(bid)).build().render(RenderingStrategies.MYBATIS3);
        return businessDao.delete(statementProvider);
    }

    @Override
    public int addBussiness(Integer id) {
        Business business = new Business();
        business.setGrorderId(id);
        return businessDao.insertSelective(business);
    }
}
