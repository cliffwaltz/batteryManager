package cn.ys.service;

import cn.ys.dto.PageList;
import cn.ys.entity.Admin;
import cn.ys.entity.Menu;
import cn.ys.entity.Role;

import java.util.List;

public interface PermissionService {
    List<Menu> getSelfMenus(Admin admin);

    List<Role> findAdminRolebyid(Integer id);

    List<Role> findAllRoles();

    boolean updateAdminRole(Integer[] roles,Integer key);

    PageList<Role> findAllPageRoles(Integer page, Integer rows);

    boolean addRole(Role role);

    Role findRoleById(Integer id);

    boolean updateRole(Role role, Integer key);

    boolean deleteRoleById(Integer id);

    List<Menu> findAllMenus();

    List<Menu> findRoleMenubyid(Integer id);

    boolean updateRoleMenu(Integer[] menus, Integer key);

    PageList<Menu> findAllPageMenus(Integer page, Integer rows);

    boolean addMenu(Menu menu);

    Menu findMenuById(Integer id);

    boolean updateMenu(Menu menu, Integer key);

    boolean deleteMenuById(Integer id);
}
