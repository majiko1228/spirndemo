package cn.ndky.common.status;

import lombok.Getter;

@Getter
public enum RoleType {

    STUDENT("student","学生"),
    TEACHER("teacher","教师"),
    ADMIN("admin","管理员");

    private String roleId;
    private String roleName;

    RoleType(String roleId, String roleName){
        this.roleId = roleId;
        this.roleName = roleName;
    }

}
