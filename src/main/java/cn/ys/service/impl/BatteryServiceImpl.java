package cn.ys.service.impl;

import cn.ys.dao.BatteryMapper;
import cn.ys.dao.UserMapper;
import cn.ys.dto.PageList;
import cn.ys.entity.Battery;
import cn.ys.entity.User;
import cn.ys.service.BatteryService;
import cn.ys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatteryServiceImpl implements BatteryService {
    @Autowired
    private BatteryMapper batteryMapper;

    @Override
    public PageList<Battery> findAll(Integer page, Integer rows) {
        List<Battery> listbattery = batteryMapper.findAll((page-1)*rows,rows);
        int total = batteryMapper.findTotal();
        PageList<Battery> listbatterys = new PageList<>();
        listbatterys.setTotal(total);
        listbatterys.setRows(listbattery);
        return listbatterys;
    }

    @Override
    public boolean addBattery(Battery battery) {
        boolean res = batteryMapper.addBattery(battery);
        return res;
    }

    @Override
    public Battery findBatteryById(String id) {
        Battery battery = batteryMapper.findBatteryById(id);
        return battery;
    }

    @Override
    public boolean deleteBatteryById(String id) {
        boolean res = batteryMapper.deleteBatteryById(id);
        return res;
    }

    @Override
    public boolean updateBattery(Battery battery,Integer key){
        boolean res = batteryMapper.updateBattery(battery, key);
        return res;
    }
}
