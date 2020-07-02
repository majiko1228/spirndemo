package cn.ndky.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面跳转控制器
 */
@Controller
public class RouterController {

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/welcome")
    public String welcome(){
        return "login";
    }

    /**
     * 主页
     * @return
     */
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
