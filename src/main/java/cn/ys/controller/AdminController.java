package cn.ys.controller;


import cn.ys.dto.PageList;
import cn.ys.entity.Admin;
import cn.ys.entity.Menu;
import cn.ys.entity.Role;
import cn.ys.service.AdminService;
import cn.ys.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    PermissionService permissionService;

    @RequestMapping("login")
    public ModelAndView login(Admin admin){
        System.out.println(admin);
        Admin trueAdmin = adminService.getAdminByName(admin.getUsername());
        System.out.println("true:"+trueAdmin);
        if(trueAdmin==null){
            return new ModelAndView("redirect:/pages/login.jsp");
        }
        else if(trueAdmin.getPassword().equals(admin.getPassword())){
            System.out.println("密码正确");
            List<Menu> menus = getSelfMenus(trueAdmin);
            ModelAndView mv = new ModelAndView("/pages/main","admin",admin);
            mv.addObject("menus",menus);
            return mv;
        }else{
            System.out.println("密码错误");
            return new ModelAndView("redirect:/pages/login.jsp");
        }
    }

    @RequestMapping("findselfbyid")
    @ResponseBody
    public List<Admin> findSelfById(String username){
        System.out.println("username:"+username);
        Admin admin = adminService.getAdminByName(username);
        List<Admin> listadmin= new ArrayList<>();
        listadmin.add(admin);
        System.out.println("admin:"+admin);
        return listadmin;
    }


    @RequestMapping("findall")
    @ResponseBody
    public PageList<Admin> findAll(Integer page, Integer rows){
        PageList<Admin> listadmin = adminService.findAll(page,rows);
        return listadmin;
    }

    @RequestMapping("addadmin")
    @ResponseBody
    public boolean addAdmin(Admin admin){
        System.out.println(admin);
        boolean res = adminService.addAdmin(admin);
        return res;
    }

    @RequestMapping("findonebyid")
    @ResponseBody
    public Admin findAdminById(String id){
        System.out.println(id);
        Admin admin = adminService.findAdminById(id);
        return admin;
    }

    @RequestMapping("updateadmin")
    @ResponseBody
    public boolean updateAdmin(Admin admin,Integer key){
        System.out.println(admin);
        System.out.println("key:"+key);
        boolean res = adminService.updateAdmin(admin,key);
        return res;
    }

    @RequestMapping("deletebyid")
    @ResponseBody
    public boolean deleteByAdminId(String id){
        System.out.println(id);
        boolean res = adminService.deleteAdminById(id);
        return res;
    }

    @RequestMapping("findAdminRolebyid")
    @ResponseBody
    public List<Role> findAdminRolebyid(Integer id){
        List<Role> listrole = permissionService.findAdminRolebyid(id);
        return listrole;
    }

    @RequestMapping("updateAdminRole")
    @ResponseBody
    public boolean updateAdminRole(Integer[] roles,Integer key){

        permissionService.updateAdminRole(roles,key);

        return true;
    }

    
    
    
    
    
    public List<Menu> getSelfMenus(Admin admin){
        List<Menu> menus = permissionService.getSelfMenus(admin);
        return menus;
    }
}
