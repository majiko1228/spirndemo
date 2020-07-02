package cn.ndky.pojo;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String password;
    private String name;
    private Integer status;

    // 用户角色
    private String roleDesc;
}
