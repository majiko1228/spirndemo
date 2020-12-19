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
@TableName(value = "tb_department")
public class Department {
    /**
     * 主键id
     */
    @TableId(value = "department_id",type = IdType.AUTO)
    private int departmentId;
    /**
     * 姓名
     */
    @TableField(value = "department_name")
    private String departmentName;

}
