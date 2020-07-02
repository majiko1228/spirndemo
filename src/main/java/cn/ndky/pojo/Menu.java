package cn.ndky.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Menu {

    @JsonIgnore
    private int permId;
    @JsonIgnore
    private int parentId;

    private String title;
    private String icon;
    private String href;
    private String image;
    private String target;
    @JsonIgnore
    private String desc;
    private List<Menu> child = new ArrayList<>();

}
