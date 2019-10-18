package cn.ys.service.impl;

import cn.ys.dao.CarMapper;
import cn.ys.dao.UserMapper;
import cn.ys.dto.PageList;
import cn.ys.entity.User;
import cn.ys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CarMapper carMapper;

    @Override
    public PageList<User> findAll(Integer page,Integer rows) {
        List<User> listuser = userMapper.findAll((page-1)*rows,rows);
        int total = userMapper.findTotal();
        PageList<User> listusers = new PageList<>();
        listusers.setTotal(total);
        listusers.setRows(listuser);
        return listusers;
    }

    @Override
    public boolean addUser(User user) {
        boolean res = userMapper.addUser(user);
        return res;
    }

    @Override
    public User findCarById(String id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    @Override
    public boolean deleteUserById(String id) {
        boolean res = userMapper.deleteUserById(id);
        return res;
    }

    @Override
    public boolean updateCar(User user,String key){
        boolean res = userMapper.updateUser(user, key);
        carMapper.updateCarsCauseUser(user,key);
        return res;
    }
}
