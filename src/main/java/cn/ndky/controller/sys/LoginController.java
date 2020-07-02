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
        System.out.println("userId "+userId+" password "+password);
        return userService.login(userId,password,session);
    }

    @PostMapping("/logout")
    public RespObj logout(){
       return userService.logout();
    }

    @GetMapping("/initMenu")
    public Map<String,Object> initMenu(){
        /*
        Map<String,Object> map = new HashMap<>();
        Menu menu = new Menu();
        menu.setTitle("首页");
        menu.setHref("");

        Menu menu5 = new Menu();
        menu5.setTitle("LAYUI MINI");
        menu5.setHref("");
        menu5.setImage("layuimini/images/logo.png");


        List<Menu> menuList = new ArrayList<>();

        Menu menu1 = new Menu();
        menu1.setTitle("常规管理");
        menu1.setIcon("fa fa-address-book");
        menu1.setHref("");
        menu1.setTarget("_self");


        List<Menu> childList = new ArrayList<>();

        Menu menu2 = new Menu();
        menu2.setTitle("主页模板");
        menu2.setIcon("fa fa-address-book");
        menu2.setHref("");
        menu2.setTarget("_self");
        Menu menu3 = new Menu();
        menu3.setTitle("用户管理");
        menu3.setIcon("fa fa-address-book");
        menu3.setHref("");
        menu3.setTarget("_self");
        childList.add(menu2);
        childList.add(menu3);

        menu1.setChild(childList);

        menuList.add(menu1);

        map.put("homeInfo",menu);
        map.put("logoInfo",menu5);
        map.put("menuInfo",menuList);


        System.out.println("map "+map);

        return  map;
        */
        return userService.initMenu();
    }

}
