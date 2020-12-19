package cn.ndky.mapper;

import cn.ndky.pojo.Menu;
import cn.ndky.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {

    public User getUserByUserId(String userId);

    public List<String> getRoleIdsByUserId(String userId);

    public List<String> getRoleNamesByUserId(String userId);

    public List<Menu> getMenu(List<String> roles);
}
