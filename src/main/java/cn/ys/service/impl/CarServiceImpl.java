package cn.ys.service.impl;

import cn.ys.dao.CarMapper;
import cn.ys.dao.UserMapper;
import cn.ys.dto.PageList;
import cn.ys.entity.Car;
import cn.ys.entity.User;
import cn.ys.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private UserMapper userMapper;
    @Override
    public PageList<Car> findall(Integer page,Integer rows) {
        List<Car> carlist = carMapper.findAll((page-1)*rows,rows);
        int total = carMapper.selectCount();
        PageList<Car> carPageList = new PageList<>();
        carPageList.setRows(carlist);
        carPageList.setTotal(total);
        return carPageList;
    }

    @Override
    public boolean deleteCarById(String carid) {
        boolean res = carMapper.deleteCarById(carid);
        return res;
    }

    @Override
    public boolean addCar(Car car) {
        boolean res = carMapper.addCar(car);
        return res;
    }

    @Override
    public Car findCarById(String carId) {
        Car car = carMapper.findOneById(carId);
        return car;
    }

    @Override
    public boolean updateCar(Car car,String key){
        boolean res = carMapper.updateCar(car, key);
        return res;
    }

    @Override
    public User FindUserByCarId(String carId) {
        User user = carMapper.FindUserByCarId(carId);
        return user;
    }

    @Override
    public boolean unBind(String carId) {
        boolean res = carMapper.unBind(carId);
        return res;
    }

    @Override
    @Transactional
    public boolean BindUser(User user, String carId,String userId) {
        System.out.println("user:"+user);
        System.out.println("carId:"+carId);
        System.out.println("userId:"+userId);
        if(userId.equals("null")||userId.equals("")){
            System.out.println("useridisnull");
            User ishave = userMapper.findUserById(user.getId());
            if(ishave==null){
                userMapper.addUser(user);
                System.out.println("添加成功");
                //update car set user_id=#{user.id},user_name=#{user.name} where car_id=#{carId}
                boolean res = carMapper.updateCarBindUser(user,carId);
                return res;
            }else{
                userMapper.updateUser(user,user.getId());
                carMapper.updateCarBindUser(user,carId);
                //update car set user_name=#{name} where user_id=#{id}
                boolean res = carMapper.updateCarsCauseUser(user,userId);
                return true;
            }
        }else{
            userMapper.updateUser(user,userId);
            boolean res = carMapper.updateCarsCauseUser(user,userId);
            return res;
        }

    }
}
