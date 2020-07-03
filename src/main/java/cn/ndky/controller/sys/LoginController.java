package cn.ndky.controller.sys;

import cn.ndky.common.RespObj;
import cn.ndky.pojo.Menu;
import cn.ndky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录控制器
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public RespObj login(String userId, String password, HttpSession session){
        return userService.login(userId,password,session);
    }

    @PostMapping("/logout")
    public RespObj logout(){
       return userService.logout();
    }

    @GetMapping("/initMenu")
    public Map<String,Object> initMenu(){
        return userService.initMenu();
    }

}
