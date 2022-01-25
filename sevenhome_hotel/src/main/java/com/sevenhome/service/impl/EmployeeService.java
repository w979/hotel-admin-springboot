package com.sevenhome.service.impl;

import com.sevenhome.bean.po.Employee;
import com.sevenhome.bean.vo.EmployeeVo;
import com.sevenhome.dao.EmployeeDao;
import com.sevenhome.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * lee
 */
@Service
@Transactional
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 查询员工个人信息
     * @author lee
     * @param username
     * @return
     */
    @Override
    public EmployeeVo findEmployeeByUserName(String username) {

        Employee emp = employeeDao.findEmployeeByUserName(username);
        //将Po对象转为Vo
        EmployeeVo employeeVo = new EmployeeVo();
        employeeVo.setHotelId(emp.getHotelId());
        employeeVo.setId(emp.getId());
        employeeVo.setPermList(emp.getPermList());
        employeeVo.setEmpImg(emp.getEmpImg());
        employeeVo.setEmpname(emp.getEmpname());
        employeeVo.setEmpNumber(emp.getEmpNumber());
        employeeVo.setEmpSalary(emp.getEmpSalary());
        employeeVo.setEmpStatus(emp.getEmpStatus());
        employeeVo.setRole(emp.getRole());
        employeeVo.setSex(emp.getSex());

        return employeeVo;
    }

    /**
     * 查询所有员工信息
     * @author lee
     * @return
     */
    @Override
    public List<EmployeeVo> findAllEmp(Integer id) {
        List<Employee> allEmp = employeeDao.findAllEmp(id);
        System.out.println("server层的数据"+allEmp.toString());
        //将Po对象转为Vo
        ArrayList<EmployeeVo> employeeVos = new ArrayList<>();
        for (Employee employee : allEmp){
            EmployeeVo employeeVo = new EmployeeVo();
            employeeVo.setHotelId(employee.getHotelId());
            employeeVo.setId(employee.getId());
            employeeVo.setPermList(employee.getPermList());
            employeeVo.setEmpImg(employee.getEmpImg());
            employeeVo.setEmpname(employee.getEmpname());
            employeeVo.setEmpNumber(employee.getEmpNumber());
            employeeVo.setEmpSalary(employee.getEmpSalary());
            employeeVo.setEmpStatus(employee.getEmpStatus());
            employeeVo.setRole(employee.getRole());
            employeeVo.setSex(employee.getSex());
            employeeVos.add(employeeVo);
        }
        return employeeVos;
    }

    @Override
    public List<EmployeeVo> findAllEmpByHotelId(String username) {
        Employee employeeByUserName = employeeDao.findEmployeeByUserName(username);
        List<Employee> allEmp = employeeDao.findAllEmp(employeeByUserName.getHotelId());
        //将Po对象转为Vo
        ArrayList<EmployeeVo> employeeVos = new ArrayList<>();
        for (Employee employee : allEmp){
            EmployeeVo employeeVo = new EmployeeVo();
            employeeVo.setHotelId(employee.getHotelId());
            employeeVo.setId(employee.getId());
            employeeVo.setPermList(employee.getPermList());
            employeeVo.setEmpImg(employee.getEmpImg());
            employeeVo.setEmpname(employee.getEmpname());
            employeeVo.setEmpNumber(employee.getEmpNumber());
            employeeVo.setEmpSalary(employee.getEmpSalary());
            employeeVo.setEmpStatus(employee.getEmpStatus());
            employeeVo.setRole(employee.getRole());
            employeeVo.setSex(employee.getSex());
            employeeVos.add(employeeVo);
        }
        return employeeVos;
    }
}
