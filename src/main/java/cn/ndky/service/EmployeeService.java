package cn.ndky.service;

import cn.ndky.common.RespObj;
import cn.ndky.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    RespObj selectAll(int page,int limit);
}
