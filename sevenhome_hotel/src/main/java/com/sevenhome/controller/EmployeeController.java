package com.sevenhome.controller;

import com.sevenhome.bean.po.Employee;
import com.sevenhome.bean.vo.EmployeeVo;
import com.sevenhome.service.IEmployeeService;
import com.sevenhome.utils.ResponseResult;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * lee
 * 员工
 */
@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    /**
     * 查询员工个人信息
     * @author lee
     * @return
     */
    @GetMapping("employee/findEmployeeByUserName")
    public ResponseResult<Object> findEmployeeByUserName(String username){
        System.out.println(username);
        EmployeeVo employeeByUserName = iEmployeeService.findEmployeeByUserName(username);
        if (employeeByUserName!=null){
            System.out.println(employeeByUserName);
            return new ResponseResult<>(200,"查询员工个人信息成功！",employeeByUserName);
        }
        return null;
    }

    /**
     * 查询所有员工信息
     * @author lee
     */
    @GetMapping("employee/findAllEmp")
    public ResponseResult<Object> findAllEmp(@RequestParam("id") Integer id){
        List<EmployeeVo> allEmp = iEmployeeService.findAllEmp(id);
        System.out.println("所有员工信息："+allEmp.toString());
        System.out.println(allEmp.toString());
        if (allEmp.size()>0){
            return new ResponseResult<>(200,"查询所有员工成功！",allEmp);
        }
        return null;
    }

    /**
     *
     */


}
