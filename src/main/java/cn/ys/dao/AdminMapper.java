package cn.ys.dao;

import cn.ys.entity.Admin;
import cn.ys.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    public Admin getAdminByName(String id);

    //根据用户id获取菜单
    List<Menu> getMenusById(Integer id);

    List<Admin> findAll(@Param("limit1") Integer limit1, @Param("limit2") Integer limit2);

    int findTotal();

    boolean addAdmin(Admin admin);

    Admin getAdminById(String id);

    boolean updateAdmin(@Param("admin") Admin admin,@Param("key") Integer key);

    boolean deleteAdminById(String id);

    boolean addRoles(@Param("addroles") List<Integer> addroles,@Param("key") Integer key);

    boolean deleteRoles(@Param("oldroles") List<Integer> oldroles,@Param("key") Integer key);
}
