package cn.ndky.controller.sys;

import cn.ndky.common.Utils;
import cn.ndky.common.status.RoleType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.PublicKey;
import java.util.List;

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


    /**
     * 主页内容
     * @return
     */
    @GetMapping("/indexContent")
    public String indexContent(Model model, HttpSession session){
        List<String> roles = Utils.getSessionUser(session).getRoles();
        for (String role : roles) {
            if(role.equals(RoleType.TEACHER.getRoleId())){
                model.addAttribute("roleId",role);
                break;
            }else if(role.equals(RoleType.STUDENT.getRoleId())){
                model.addAttribute("roleId",role);
                break;
            }else if(role.equals(RoleType.ADMIN.getRoleId())){
                model.addAttribute("roleId",role);
                break;
            }
        }
        return "index-content";
    }

    // 跳转到课程管理
    @GetMapping("/teacher/courseManage")
    public String course(){
        return "teacher/course/course";
    }

    // 跳转到我的题库
    @GetMapping("/teacher/myRepo")
    public String myRepo(){
        return "teacher/repo/myRepo";
    }

}
