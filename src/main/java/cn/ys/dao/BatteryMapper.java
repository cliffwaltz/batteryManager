package cn.ys.dao;

import cn.ys.entity.Battery;
import cn.ys.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BatteryMapper {
    //根据id查询电池
    public Battery findBatteryById(String id);

    //查询记录总数
    public int findTotal();

    //查询所有电池信息
    public List<Battery> findAll(@Param("limit1") Integer limit1, @Param("limit2") Integer limit2);

    //增加电池信息
    public boolean addBattery(Battery battery);

    //删除电池by id
    public boolean deleteBatteryById(String id);

    //修改电池信息
    public boolean updateBattery(@Param("battery") Battery battery, @Param("key") Integer key);
}
