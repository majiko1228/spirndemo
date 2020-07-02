package cn.ndky.common;

import cn.ndky.pojo.User;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();

        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setName("张三");

        User user2 = new User();
        user2.setName("李四");

        User user3 = new User();
        user3.setName("王五");


        users.add(user1);
        users.add(user2);
        users.add(user3);

        map.put("用户管理",users);
        System.out.println(map);

    }

}
