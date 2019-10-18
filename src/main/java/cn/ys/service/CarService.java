package cn.ys.service;

import cn.ys.dto.PageList;
import cn.ys.entity.Car;
import cn.ys.entity.User;

import java.util.List;

public interface CarService {
    //查询所有车辆信息
    public PageList<Car> findall(Integer page,Integer rows);

    //根据carid删除车辆信息
    public boolean deleteCarById(String carid);

    //添加车辆信息
    public boolean addCar(Car car);

    //根据ID查询车辆信息
    public Car findCarById(String carId);

    //修改车辆信息
    public boolean updateCar(Car car,String key);

    User FindUserByCarId(String carId);

    boolean BindUser(User user, String carId,String userId);

    boolean unBind(String carId);
}
