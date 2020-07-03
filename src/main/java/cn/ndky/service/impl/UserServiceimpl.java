package cn.ndky.service.impl;

import cn.ndky.common.RespObj;
import cn.ndky.common.ShiroUser;
import cn.ndky.common.Utils;
import cn.ndky.mapper.UserMapper;
import cn.ndky.pojo.Menu;
import cn.ndky.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param userId
     * @param password
     * @param session
     * @return
     */
    @Override
    public RespObj login(String userId, String password, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();

        if(!subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(userId,password);
            try{
                subject.login(token);
                session.setAttribute("currentUser",(ShiroUser)subject.getPrincipal());
                System.out.println("success");
                return RespObj.build(200,"ok",null);
            }catch (LockedAccountException lae){
                System.out.println("fail1");
                return RespObj.build(500,lae.getMessage(),null);
            }catch (Exception e){
                System.out.println("fail2");
                return RespObj.build(500,"用户名或密码错误",null);
            }
        }

        return RespObj.build(200,"ok",null);
    }

    /**
     * 用户注销
     * @return
     */
    @Override
    public RespObj logout() {
        SecurityUtils.getSubject().logout();
        return RespObj.build(200,"注销成功",null);
    }

    /**
     * 初始化菜单
     * @return
     */
    @Override
    public Map<String, Object> initMenu() {
        ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        List<Menu> menus = userMapper.getMenu(shiroUser.getRoles());
        System.out.println(menus);
        Map<String,Object> menuMap = new LinkedHashMap<>();
        List<Menu> menuList = new ArrayList<>();
        return Utils.initMenu(menus,menuList,menuMap);
        /*
        Map<String,Object> menuMap = new LinkedHashMap<>();
        Map<String,Object> map = new HashMap<>();

        return Utils.initMenu(menus,menuMap,map);
        */
    }
}
