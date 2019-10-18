package cn.ys.service;

import cn.ys.dto.PageList;
import cn.ys.entity.Battery;
import cn.ys.entity.User;

public interface BatteryService {

    //查询所有电池信息
    PageList<Battery> findAll(Integer page, Integer rows);

    //增加电池信息
    boolean addBattery(Battery battery);

    //根据id删除电池信息
    boolean deleteBatteryById(String id);

    //根据id查找电池信息
    Battery findBatteryById(String id);

    //修改电池信息
    boolean updateBattery(Battery battery, Integer key);
}
