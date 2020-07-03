package cn.ndky.common;

import cn.ndky.pojo.Menu;
import org.apache.shiro.crypto.hash.SimpleHash;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class Utils {

    /**
     * 动态初始化左侧菜单
     * @param menus
     * @param menuList
     * @param menuMap
     * @return
     */
    public static Map<String,Object> initMenu(List<Menu> menus, List<Menu> menuList, Map<String,Object> menuMap){
        for (Menu menu : menus) {
            if(menu.getParentId() == 0){
                if(menu.getDesc().equals("homeInfo")){
                    menuMap.put("homeInfo",menu);
                }else if(menu.getDesc().equals("logoInfo")){
                    menuMap.put("logoInfo",menu);
                }else {
                    for (Menu menu1:menus){
                        if(menu.getPermId() == menu1.getParentId()){
                            menu.getChild().add(menu1);
                        }
                    }
                    menuList.add(menu);
                }
            }else {
                for (Menu menu1 : menus) {
                    if (menu.getPermId() == menu1.getParentId()) {
                        menu.getChild().add(menu1);
                    }
                }

            }
        }

        menuMap.put("menuInfo",menuList);
        return menuMap;
    }



    /**
     * 获取session域里存储的用户
     * @param session
     * @return
     */
    public static ShiroUser getSessionUser(HttpSession session){
        return (ShiroUser)session.getAttribute("currentUser");
    }

    /**
     * 密码加密
     */
    public static String encryptPwd(String password,String salt ){
        return new SimpleHash("MD5",password,salt,1024).toString();
    }
}
