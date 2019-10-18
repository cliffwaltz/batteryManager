package cn.ys.controller;

import cn.ys.dto.PageList;
import cn.ys.entity.Car;
import cn.ys.entity.User;
import cn.ys.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("findall")
    @ResponseBody
    public PageList<Car> findAll(Integer page, Integer rows){
        PageList<Car> pageCarlist = carService.findall(page,rows);
        return pageCarlist;
    }

    @RequestMapping("deletebyid")
    @ResponseBody
    public boolean deleteByCarId(String carid){
        System.out.println(carid);
        boolean res = carService.deleteCarById(carid);
        return res;
    }

    @RequestMapping("addcar")
    @ResponseBody
    public boolean addCar(Car car){
        System.out.println(car);
        boolean res = carService.addCar(car);
        return res;
    }

    @RequestMapping("findonebyid")
    @ResponseBody
    public Car findCarById(String carId){
        System.out.println(carId);
        Car car = carService.findCarById(carId);
        return car;
    }

    @RequestMapping("updatecar")
    @ResponseBody
    public boolean updateCar(Car car,String key){
        System.out.println(car);
        boolean res = carService.updateCar(car,key);
        return res;
    }


    @RequestMapping("searchByCarId")
    @ResponseBody
    public PageList<Car> SearchByCarId(Integer page, Integer rows){
        PageList<Car> pageCarlist = carService.findall(page,rows);
        return pageCarlist;
    }

    @RequestMapping("finduserbycarid")
    @ResponseBody
    public User FindUserByCarId(String carId){
        User user = carService.FindUserByCarId(carId);
        return user;
    }

    @RequestMapping("binduser")
    @ResponseBody
    public boolean BindUser(User user,String carId,String userId){
        boolean res = carService.BindUser(user,carId,userId);
        return res;
    }

    @RequestMapping("unbinduser")
    @ResponseBody
    public boolean UnBind(String carId){
        System.out.println("carId:"+carId);
        boolean res = carService.unBind(carId);
        System.out.println("res:"+res);
        return res;
    }
}
