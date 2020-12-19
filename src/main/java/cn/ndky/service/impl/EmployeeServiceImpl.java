package cn.ndky.service.impl;

import cn.ndky.common.RespObj;
import cn.ndky.mapper.EmployeeMapper;
import cn.ndky.pojo.Employee;
import cn.ndky.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    EmployeeMapper employeeMapper;

    @Override
    public RespObj selectAll(int page,int limit) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        Page<Employee> myPage =new Page<>(page,limit);
        IPage<Employee> userIPage = employeeMapper.selectPage(myPage,queryWrapper);
        return RespObj.build(userIPage);
    }
}
