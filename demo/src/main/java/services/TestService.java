package services;

import db.model.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
public interface TestService {
    public List<Test> getTestListByParam(Test test);

    public void addTest(Test test);

    public void modifyTest(Test test);

    public Test getTestById(String id);
}
