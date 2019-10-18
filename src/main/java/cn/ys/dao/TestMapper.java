package cn.ys.dao;

import cn.ys.entity.TestBean;
import org.springframework.stereotype.Repository;


public interface TestMapper {
    public TestBean getTestBeanById(Integer id);
}
