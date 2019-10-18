package cn.ys.dao;

import cn.ys.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    List<Role> findRoleByAdminId(Integer id);

    List<Role> findAll();

    List<Role> findAllPageRoles(@Param("limit1") Integer limit1, @Param("limit2") Integer limit2);

    int findTotal();

    boolean addRole(Role role);

    Role findRoleById(Integer id);

    boolean updateRole(@Param("role") Role role,@Param("key") Integer key);

    boolean deleteRoleById(Integer id);

    boolean addMenus(@Param("addmenus") List<Integer> addmenus, @Param("key") Integer key);

    boolean deleteMenus(@Param("oldmenus") List<Integer> oldmenus,@Param("key")  Integer key);
}
