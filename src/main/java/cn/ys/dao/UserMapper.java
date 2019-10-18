package cn.ys.dao;

import cn.ys.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //根据id查询车主
    public User findUserById(String id);

    //查询记录总数
    public int findTotal();

    //查询所有车主信息
    public List<User> findAll(@Param("limit1") Integer limit1, @Param("limit2") Integer limit2);

    //增加车主信息
    public boolean addUser(User user);

    //删除车主by id
    public boolean deleteUserById(String id);

    //修改车主信息
    public boolean updateUser(@Param("user") User user,@Param("key") String key);
}
