package services.impl;

import db.dao.TestMapper;
import db.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.TestService;

import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
@Service("testService")
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<Test> getTestListByParam(Test test) {
        return testMapper.selectListByParam(test);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addTest(Test test) {
        testMapper.insertSelective(test);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyTest(Test test) {
        testMapper.updateByPrimaryKeySelective(test);
    }

    @Override
    @Transactional(readOnly = true)
    public Test getTestById(String id) {
        return testMapper.selectByPrimaryKey(id);
    }
}
