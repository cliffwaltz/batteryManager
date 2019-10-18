package cn.ys.dao;

import cn.ys.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    List<Menu> findAll();

    List<Menu> findSonMenusById(Integer id);

    List<Menu> findParentMenusById(Integer parentId);

    List<Menu> findRoleMenubyid(Integer id);

    List<Menu> findAllPages(@Param("limit1") Integer limit1, @Param("limit2") Integer limit2);

    int findTotal();

    boolean addMenu(Menu menu);

    Menu findMenuById(Integer id);

    boolean updateMenu(@Param("menu") Menu menu,@Param("key") Integer key);

    boolean deleteMenuById(Integer id);
}
