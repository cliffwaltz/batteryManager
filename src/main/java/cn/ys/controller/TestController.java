package cn.ys.controller;


import cn.ys.entity.Car;
import cn.ys.entity.TestBean;
import cn.ys.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("getone")
    public ModelAndView getOneById(Integer id){
        TestBean testbean = testService.findOneById(id);

        return new ModelAndView("success","data",testbean);
    }

    @RequestMapping("findall")
    @ResponseBody
    public List<Car> findall(){
        System.out.println("hello");
        List<Car> listcar = new ArrayList<>();
        for(int i=0;i<10;i++){
            Car car = new Car(i+"",i+"",i+"",10,"1");
            listcar.add(car);
        }
        System.out.println(listcar);
        return listcar;
    }
}
