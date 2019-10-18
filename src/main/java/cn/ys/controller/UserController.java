package cn.ys.controller;

import cn.ys.dto.PageList;
import cn.ys.entity.User;
import cn.ys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("findall")
    @ResponseBody
    public PageList<User> findAll(Integer page, Integer rows){
        PageList<User> listuser = userService.findAll(page,rows);

        return listuser;
    }

    @RequestMapping("adduser")
    @ResponseBody
    public boolean addUser(User user){
        System.out.println(user);
        boolean res = userService.addUser(user);
        return res;
    }

    @RequestMapping("deletebyid")
    @ResponseBody
    public boolean deleteByCarId(String id){
        System.out.println(id);
        boolean res = userService.deleteUserById(id);
        return res;
    }

    @RequestMapping("findonebyid")
    @ResponseBody
    public User findCarById(String id){
        System.out.println(id);
        User user = userService.findCarById(id);
        return user;
    }

    @RequestMapping("updateuser")
    @ResponseBody
    public boolean updateCar(User user,String key){
        System.out.println(user);
        boolean res = userService.updateCar(user,key);
        return res;
    }
}
