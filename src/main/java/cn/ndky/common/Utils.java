package cn.ndky.common;

import cn.ndky.pojo.Menu;

import java.util.List;
import java.util.Map;

public class Utils {

    /**
     * 动态初始化左侧菜单
     * @param menus
     * @param menuMap
     * @param map
     * @return
     */
    public static Map<String,Object> initMenu(List<Menu> menus, Map<String,Object> menuMap, Map<String,Object> map){
        for (Menu menu : menus) {
            if(menu.getParentId() != 0){
                for (Menu menu1 : menus) {
                    if(menu.getParentId() == menu1.getPermId()){
                        menu1.getChild().add(menu);
                    }
                }
            }
        }

        for (Menu menu : menus) {
            if(menu.getChild().size() == 0){
                menu.setChild(null);
            }
        }

        for (Menu menu : menus) {
            if(menu.getParentId() == 0){
                if(!menu.getDesc().equals("menuInfo")){
                    menuMap.put(menu.getDesc(),menu);
                }else{
                    map.put("desktop",menu);
                    menuMap.put(menu.getDesc(),map);
                }
            }
        }

        return menuMap;
    }
}
