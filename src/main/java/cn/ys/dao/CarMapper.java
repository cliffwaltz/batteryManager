package cn.ys.dao;

import cn.ys.entity.Car;
import cn.ys.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {

    //根据Id查询车辆信息
    public Car findOneById(String carid);

    // 查询所有的车辆信息
    public List<Car> findAll(@Param("limit1") Integer limit1, @Param("limit2") Integer limit2);

    //查询记录数
    public int selectCount();

    //删除车辆by id
    public boolean deleteCarById(String carid);

    //添加车辆信息
    public boolean addCar(Car car);

    //修改车辆信息
    public boolean updateCar(@Param("car") Car car,@Param("key") String key);


    //根据carid查找车主
    User FindUserByCarId(String carId);

    //update car set user_id=#{user.id},user_name=#{user.name} where car_id=#{carId}
    //根据车辆id修改车辆信息中的车主信息
    boolean updateCarBindUser(@Param("user") User user,@Param("carId") String carId);

    //update car set user_name=#{name} where user_id=#{id}
    //修改由于车主信息变化而发生变化的车辆信息
    boolean updateCarsCauseUser(@Param("user") User user,@Param("userId") String userId);

    //解绑车主信息
    boolean unBind(String carId);
}
