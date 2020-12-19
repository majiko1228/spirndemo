package cn.ndky.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor//使用后创建一个无参构造函数
@TableName(value = "tb_employee")
public class Employee {
    /**
     * 用户主键id
     */
    @TableId(value = "employee_id",type = IdType.AUTO)
    private int employeeId;

    /**
     * 姓名
     */
    @TableField(value = "employee_name")
    private String employeeName;

    /**
     * 性别
     */
    @TableField(value = "employee_sex")
    private int employeeSex;
    /**
     * 年龄
     */
    @TableField(value = "employee_age")
    private int employeeAge;

    /**
     * 部门id
     */
    @TableField(value = "employee_department")
    private Department department;
    /**
     * 生日
     */
    @TableField(value = "employee_birth")
    private Date employeeBirth;
    /**
     * 手机
     */
    @TableField(value = "employee_phone")
    private String employeePhone;
    /**
     * 邮箱
     */
    @TableField(value = "employee_email")
    private String employeeEmail;

    /**
     * 描述
     */
    @TableField(value = "employee_decs")
    private String employeeDecs;


}
