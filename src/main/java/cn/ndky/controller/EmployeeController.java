package cn.ndky.controller;


import cn.ndky.common.RespObj;
import cn.ndky.service.EmployeeService;
import cn.ndky.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(("/employee"))
public class EmployeeController {

    @Resource
    EmployeeService employeeService;
    /**
     * 跳转到员工管理
     */
    @GetMapping("/index")
    public String employeeIndex(){
        return "employee/index";
    }

    @GetMapping("/list")
    @ResponseBody
    public RespObj List(int page,int limit){

        return employeeService.selectAll(page,limit);
    }
}
