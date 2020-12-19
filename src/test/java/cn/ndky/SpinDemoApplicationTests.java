package cn.ndky;

import cn.ndky.common.Utils;
import cn.ndky.mapper.UserMapper;
import cn.ndky.service.EmployeeService;
import cn.ndky.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpinDemoApplicationTests {

    @Resource
    EmployeeService employeeService;

    @Resource
    UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(employeeService.selectAll(1,15));
    }

    @Test
    void getPassword(){
        System.out.println(Utils.encryptPwd("123","admin"));
    }
}
