package cn.ndky.service;

import cn.ndky.common.RespObj;
import cn.ndky.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 用户登录
     * @param userId
     * @param password
     * @param session
     * @return
     */
    public RespObj login(String userId, String password, HttpSession session);

    /**
     * 用户注销
     * @return
     */
    public RespObj logout();


    /**
     * 初始化菜单
     * @return
     */
    public Map<String,Object> initMenu();

    /**
     * 获取用户列表
     */
    public RespObj getAllUser(int pageIndex,int pageSize);
}
