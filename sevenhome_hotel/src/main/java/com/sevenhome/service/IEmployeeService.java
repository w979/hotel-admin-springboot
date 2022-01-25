package com.sevenhome.service;

import com.sevenhome.bean.po.Employee;
import com.sevenhome.bean.vo.EmployeeVo;

import java.util.List;

/**
 * lee
 */
public interface IEmployeeService {

    /**
     * 查询员工个人信息
     * @param username
     * @return
     */
    EmployeeVo findEmployeeByUserName(String username);

    /**
     * 查询所有员工信息
     * @return
     */
    List<EmployeeVo> findAllEmpByHotelId(String username);

    /**
     * 根据id查询所有员工信息
     * @return
     */
    List<EmployeeVo> findAllEmp(Integer id);
}
