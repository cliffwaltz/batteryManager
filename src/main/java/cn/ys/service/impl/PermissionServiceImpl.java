package cn.ys.service.impl;

import cn.ys.dao.AdminMapper;
import cn.ys.dao.MenuMapper;
import cn.ys.dao.RoleMapper;
import cn.ys.dto.PageList;
import cn.ys.entity.Admin;
import cn.ys.entity.Menu;
import cn.ys.entity.Role;
import cn.ys.service.PermissionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.util.*;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    MenuMapper menuMapper;


    @Override
    public List<Menu> getSelfMenus(Admin admin) {
        List<Menu> menus = adminMapper.getMenusById(admin.getId());
        System.out.println(menus);
        List<Menu> truemenus = new ArrayList<>(menus);
        for (Menu menu : menus) {
            if (menu.getId() == 0) {
                List<Menu> allMenus = menuMapper.findAll();
                return allMenus;
            } else {
                if (menu.getLevel().equals("1")) {
                    List<Menu> sonMenus = menuMapper.findSonMenusById(menu.getId());
                    truemenus.addAll(sonMenus);
                }
                if (menu.getLevel().equals("2")) {
                    List<Menu> parentMenus = menuMapper.findParentMenusById(menu.getParentId());
                    truemenus.addAll(parentMenus);
                }
            }
        }
        Set<Menu> set = new HashSet<>(truemenus);
        truemenus.clear();
        truemenus.addAll(set);
        System.out.println(truemenus);
        Collections.sort(truemenus, new Comparator<Menu>() {
            @Override
            public int compare(Menu o1, Menu o2) {
                if (Integer.parseInt(o1.getLevel()) < Integer.parseInt(o2.getLevel())) {
                    return -1;
                } else if (o1.getSort() < o2.getSort()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        System.out.println(truemenus);
        return truemenus;
    }

    @Override
    public List<Role> findAdminRolebyid(Integer id) {
        List<Role> listrole = roleMapper.findRoleByAdminId(id);
        return listrole;
    }

    @Override
    public List<Role> findAllRoles() {
        List<Role> listrole = roleMapper.findAll();
        return listrole;
    }

    @Override
    @Transactional
    public boolean updateAdminRole(Integer[] roles,Integer key) {
        List<Role> listrole = findAdminRolebyid(key);
        List<Integer> ls = new ArrayList<>();
        if(roles!=null){
            ls = Arrays.asList(roles);
            System.out.println("roles!=null");
        }
        List<Integer> addroles = new ArrayList<>(ls);
        List<Integer> oldroles = new ArrayList<>();
        for(Role role:listrole){
            oldroles.add(role.getId());
        }
        addroles.removeAll(oldroles);
        System.out.println("需要增加的："+addroles);


        List<Integer> ll = new ArrayList<>();
        if(roles!=null){
            ll = Arrays.asList(roles);
            System.out.println("roles!=null");
        }
        List<Integer> addroles2 = new ArrayList<>(ll);
        oldroles.removeAll(addroles2);
        System.out.println("需要减去的："+oldroles);

        if(addroles.size()>0){
            boolean res1 = adminMapper.addRoles(addroles,key);
        }
        if(oldroles.size()>0){
            boolean res2 = adminMapper.deleteRoles(oldroles,key);
        }
        return true;
    }

    @Override
    public PageList<Role> findAllPageRoles(Integer page, Integer rows) {
        List<Role> listrole = roleMapper.findAllPageRoles((page-1)*rows,rows);
        int total = roleMapper.findTotal();
        PageList<Role> listroles = new PageList<>();
        listroles.setTotal(total);
        listroles.setRows(listrole);
        return listroles;
    }

    @Override
    public boolean addRole(Role role) {
        return roleMapper.addRole(role);
    }

    @Override
    public Role findRoleById(Integer id) {
        return roleMapper.findRoleById(id);
    }

    @Override
    public boolean updateRole(Role role, Integer key) {
        return roleMapper.updateRole(role,key);
    }

    @Override
    public boolean deleteRoleById(Integer id) {
        return roleMapper.deleteRoleById(id);
    }

    @Override
    public List<Menu> findAllMenus() {
        return menuMapper.findAll();
    }

    @Override
    public List<Menu> findRoleMenubyid(Integer id) {
        return menuMapper.findRoleMenubyid(id);
    }

    @Override
    public boolean updateRoleMenu(Integer[] menus, Integer key) {
        List<Menu> listmenu = findRoleMenubyid(key);
        System.out.println("listmenu"+listmenu);
        List<Integer> ls = new ArrayList<>();
        if(menus!=null){
            ls = Arrays.asList(menus);
            System.out.println("menus!=null");
        }
        List<Integer> addmenus = new ArrayList<>(ls);
        List<Integer> oldmenus = new ArrayList<>();
        for(Menu menu:listmenu){
            oldmenus.add(menu.getId());
        }
        addmenus.removeAll(oldmenus);
        System.out.println("需要增加的："+addmenus);


        List<Integer> ll = new ArrayList<>();
        if(menus!=null){
            ll = Arrays.asList(menus);
            System.out.println("roles!=null");
        }
        List<Integer> addmenus2 = new ArrayList<>(ll);
        oldmenus.removeAll(addmenus2);
        System.out.println("需要减去的："+oldmenus);

        if(addmenus.size()>0){
            boolean res1 = roleMapper.addMenus(addmenus,key);
        }
        if(oldmenus.size()>0){
            boolean res2 = roleMapper.deleteMenus(oldmenus,key);
        }
        return true;
    }

    @Override
    public PageList<Menu> findAllPageMenus(Integer page, Integer rows) {
        List<Menu> listmenu = menuMapper.findAllPages((page-1)*rows,rows);
        int total = menuMapper.findTotal();
        PageList<Menu> listmenus = new PageList<>();
        listmenus.setTotal(total);
        listmenus.setRows(listmenu);
        return listmenus;
    }

    @Override
    public boolean addMenu(Menu menu) {
        boolean res = menuMapper.addMenu(menu);
        return res;
    }

    @Override
    public Menu findMenuById(Integer id) {
        Menu menu = menuMapper.findMenuById(id);
        return menu;
    }

    @Override
    public boolean updateMenu(Menu menu, Integer key) {
        boolean res = menuMapper.updateMenu(menu, key);
        return res;
    }

    @Override
    public boolean deleteMenuById(Integer id) {
        boolean res = menuMapper.deleteMenuById(id);
        return res;
    }
}

