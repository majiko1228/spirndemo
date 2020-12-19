package cn.ndky.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor//使用后创建一个无参构造函数
@TableName(value = "tb_perm")
public class Menu {

    /**
     * 用户主键id
     */
    @TableId(value = "user_id",type = IdType.AUTO)
    private int permId;
    /**
     * 父亲节点
     */
    @TableField(value = "parent_id")
    private int parentId;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;
    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;
    /**
     * url
     */
    @TableField(value = "href")
    private String href;
    /**
     * 图片
     */
    @TableField(value = "image")
    private String image;
    /**
     * target
     */
    @TableField(value = "target")
    private String target;

    /**
     * 描述
     */
    @TableField(value = "desc")
    private String desc;

    private List<Menu> child = new ArrayList<>();

}
