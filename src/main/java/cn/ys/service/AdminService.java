package cn.ys.service;

import cn.ys.dto.PageList;
import cn.ys.entity.Admin;

public interface AdminService {

    public Admin getAdminByName(String username);

    PageList<Admin> findAll(Integer page, Integer rows);

    boolean addAdmin(Admin admin);

    Admin findAdminById(String id);

    boolean updateAdmin(Admin admin, Integer key);

    boolean deleteAdminById(String id);
}
