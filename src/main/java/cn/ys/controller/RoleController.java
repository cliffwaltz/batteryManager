package cn.ys.controller;

import cn.ys.dto.PageList;
import cn.ys.entity.Menu;
import cn.ys.entity.Role;
import cn.ys.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private PermissionService permissionService;

//    @RequestMapping("findallpages")
//    @ResponseBody
//    public PageList<Role> findAll(Integer page, Integer rows){
//        PageList<Role> listrole = permissionService.findAll(page,rows);
//        return listrole;
//    }


    
    @RequestMapping("findall")
    @ResponseBody
    public List<Role> findAll(){
        List<Role> listrole = permissionService.findAllRoles();
        return listrole;
    }

    @RequestMapping("findallpages")
    @ResponseBody
    public PageList<Role> findAll(Integer page, Integer rows){
        PageList<Role> listrole = permissionService.findAllPageRoles(page,rows);
        return listrole;
    }

    @RequestMapping("addrole")
    @ResponseBody
    public boolean addRole(Role role){
        System.out.println(role);
        boolean res = permissionService.addRole(role);
        return res;
    }

    @RequestMapping("findonebyid")
    @ResponseBody
    public Role findRoleById(Integer id){
        System.out.println(id);
        Role role = permissionService.findRoleById(id);
        return role;
    }

    @RequestMapping("updaterole")
    @ResponseBody
    public boolean updateRole(Role role,Integer key){
        System.out.println(role);
        System.out.println("key:"+key);
        boolean res = permissionService.updateRole(role,key);
        return res;
    }

    @RequestMapping("deletebyid")
    @ResponseBody
    public boolean deleteByRoleId(Integer id){
        System.out.println(id);
        boolean res = permissionService.deleteRoleById(id);
        return res;
    }

    @RequestMapping("findRoleMenubyid")
    @ResponseBody
    public List<Menu> findRoleMenubyid(Integer id){
        List<Menu> listmenu = permissionService.findRoleMenubyid(id);
        return listmenu;
    }

    @RequestMapping("updateRoleMenu")
    @ResponseBody
    public boolean updateRoleMenu(@RequestParam(required = false,value = "menus[]") Integer[] menus, Integer key){
        System.out.println("jinlaile");
//        for(Integer a :menus){
//            System.out.println(a+",");
//        }
//        System.out.println("接受到了数组"+menus[0]);
//        System.out.println("接受到了key"+key);

        permissionService.updateRoleMenu(menus,key);

        return true;
    }
}
