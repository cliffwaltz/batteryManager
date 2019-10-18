package cn.ys.controller;

import cn.ys.dto.PageList;
import cn.ys.entity.Battery;
import cn.ys.entity.User;
import cn.ys.service.BatteryService;
import cn.ys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("battery")
public class BatteryController {
    @Autowired
    BatteryService batteryService;

    @RequestMapping("findall")
    @ResponseBody
    public PageList<Battery> findAll(Integer page, Integer rows){
        PageList<Battery> listbattery = batteryService.findAll(page,rows);
        return listbattery;
    }

    @RequestMapping("addbattery")
    @ResponseBody
    public boolean addBattery(Battery battery){
        System.out.println(battery);
        boolean res = batteryService.addBattery(battery);
        return res;
    }

    @RequestMapping("deletebyid")
    @ResponseBody
    public boolean deleteByBatteryId(String id){
        System.out.println(id);
        boolean res = batteryService.deleteBatteryById(id);
        return res;
    }

    @RequestMapping("findonebyid")
    @ResponseBody
    public Battery findBatteryById(String id){
        System.out.println(id);
        Battery battery = batteryService.findBatteryById(id);
        return battery;
    }

    @RequestMapping("updatebattery")
    @ResponseBody
    public boolean updateBattery(Battery battery,Integer key){
        System.out.println(battery);
        System.out.println("key:"+key);
        boolean res = batteryService.updateBattery(battery,key);
        return res;
    }
}
