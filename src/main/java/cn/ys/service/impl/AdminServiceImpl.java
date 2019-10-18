package cn.ys.service.impl;

import cn.ys.dao.AdminMapper;
import cn.ys.dto.PageList;
import cn.ys.entity.Admin;
import cn.ys.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public PageList<Admin> findAll(Integer page, Integer rows) {
        List<Admin> listadmin = adminMapper.findAll((page-1)*rows,rows);
        int total = adminMapper.findTotal();
        PageList<Admin> listadmins = new PageList<>();
        listadmins.setTotal(total);
        listadmins.setRows(listadmin);
        return listadmins;
    }

    @Override
    public Admin getAdminByName(String username) {
        Admin admin = adminMapper.getAdminByName(username);
        return admin;
    }

    @Override
    public boolean updateAdmin(Admin admin, Integer key) {
        boolean res = adminMapper.updateAdmin(admin, key);
        return res;
    }

    @Override
    public boolean deleteAdminById(String id) {
        boolean res = adminMapper.deleteAdminById(id);
        return res;
    }

    @Override
    public Admin findAdminById(String id) {
        Admin admin = adminMapper.getAdminById(id);
        return admin;
    }

    @Override
    public boolean addAdmin(Admin admin) {
        boolean res = adminMapper.addAdmin(admin);
        return res;
    }
}
