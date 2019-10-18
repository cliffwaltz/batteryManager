package cn.ys.service;

import cn.ys.dao.UserMapper;
import cn.ys.dto.PageList;
import cn.ys.entity.User;

import java.util.List;

public interface UserService {

    //查询所有车主信息
    PageList<User> findAll(Integer page,Integer rows);

    //增加车主信息
    boolean addUser(User user);

    //根据id删除车主信息
    boolean deleteUserById(String id);

    //根据id查找车主信息
    User findCarById(String id);

    //修改车主信息
    boolean updateCar(User user,String key);
}
