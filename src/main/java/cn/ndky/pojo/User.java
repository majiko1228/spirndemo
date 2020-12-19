package cn.ndky.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor//使用后创建一个无参构造函数
@TableName(value = "tb_user")
public class User {

    /**
     * 用户主键id
     */
    @TableId(value = "user_id",type = IdType.AUTO)
    private String userId;
    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 用户名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 状态
     */
    @TableField(value = "status")
    private Integer status;

}
