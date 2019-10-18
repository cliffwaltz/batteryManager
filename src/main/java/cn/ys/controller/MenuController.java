package cn.ys.controller;


import cn.ys.dto.MenuNode;
import cn.ys.dto.PageList;
import cn.ys.entity.Menu;
import cn.ys.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("findalltest")
    @ResponseBody
    public List<MenuNode> findAlltest() {
        List<Menu> listmenu = permissionService.findAllMenus();
        MenuNode topMenuNode = new MenuNode();
        List<MenuNode> secondMenuNode = new ArrayList<>();
        List<MenuNode> thirdMenuNode = new ArrayList<>();
        for (Menu menu : listmenu) {
            if (menu.getId() == 0) {
                topMenuNode.setId(0);
                topMenuNode.setText(menu.getName());
            } else if (menu.getLevel().equals("1")) {
                MenuNode menuNode = new MenuNode();
                menuNode.setId(menu.getId());
                menuNode.setText(menu.getName());
                menuNode.setParentId(menu.getParentId());

                secondMenuNode.add(menuNode);
            } else if (menu.getLevel().equals("2")) {
                MenuNode menuNode = new MenuNode();
                menuNode.setId(menu.getId());
                menuNode.setText(menu.getName());
                menuNode.setParentId(menu.getParentId());

                thirdMenuNode.add(menuNode);
            }
        }
        System.out.println("second:"+secondMenuNode);
        System.out.println("third:"+thirdMenuNode);
        for (MenuNode menuNode : secondMenuNode) {
            List<MenuNode> listMenuNode = new ArrayList<>();
            for (MenuNode sonMenuNode : thirdMenuNode) {
                if (sonMenuNode.getParentId() == menuNode.getId()) {
                    listMenuNode.add(sonMenuNode);
                }
            }
            MenuNode[] arrNode = new MenuNode[listMenuNode.size()];
            MenuNode[] menuNodes = listMenuNode.toArray(arrNode);
            menuNode.setChildren(menuNodes);
        }
        MenuNode[] arrNode = new MenuNode[secondMenuNode.size()];
        MenuNode[] menuNodes = secondMenuNode.toArray(arrNode);
        topMenuNode.setChildren(menuNodes);


        System.out.println(topMenuNode);

        List<MenuNode> res = new ArrayList<>();
        res.add(topMenuNode);

        return res;
    }


    @RequestMapping("findall")
    @ResponseBody
    public List<Menu> findAll() {
        List<Menu> listmenu = permissionService.findAllMenus();
        return listmenu;
    }

    @RequestMapping("findallpages")
    @ResponseBody
    public PageList<Menu> findAll(Integer page, Integer rows) {
        PageList<Menu> listmenu = permissionService.findAllPageMenus(page, rows);
        return listmenu;
    }

    @RequestMapping("addmenu")
    @ResponseBody
    public boolean addMenu(Menu menu) {
        System.out.println(menu);
        boolean res = permissionService.addMenu(menu);
        return res;
    }

    @RequestMapping("findonebyid")
    @ResponseBody
    public Menu findMenuById(Integer id) {
        System.out.println(id);
        Menu menu = permissionService.findMenuById(id);
        return menu;
    }

    @RequestMapping("updatemenu")
    @ResponseBody
    public boolean updateMenu(Menu menu, Integer key) {
        System.out.println(menu);
        System.out.println("key:" + key);
        boolean res = permissionService.updateMenu(menu, key);
        return res;
    }

    @RequestMapping("deletebyid")
    @ResponseBody
    public boolean deleteByMenuId(Integer id) {
        System.out.println(id);
        boolean res = permissionService.deleteMenuById(id);
        return res;
    }
}
