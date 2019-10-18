package cn.ys.service.impl;

import cn.ys.dao.TestMapper;
import cn.ys.entity.TestBean;
import cn.ys.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;
    @Override
    public TestBean findOneById(Integer id) {
        TestBean testbean = testMapper.getTestBeanById(id);
        return testbean;
    }
}
