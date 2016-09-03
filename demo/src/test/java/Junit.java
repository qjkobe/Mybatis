
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.TestService;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
public class Junit {

    @Test
    public void TestAdd(){
        String[] paths = new String[] { "spring/applicationContext-bo.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        TestService testService = (TestService) ctx.getBean("testService");

        db.model.Test test = new db.model.Test();
        test.setId("AB123");
        test.setName("qjkobe");
        test.setAge(20);
        test.setCreatetime(new Date());

        testService.addTest(test);

        test.setId("CD456");
        test.setName("qjkobe");
        test.setAge(21);
        test.setCreatetime(new Date());

        testService.addTest(test);
    }

    @Test
    public void TestUpdate(){
        String[] paths = new String[] { "spring/applicationContext-bo.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        TestService testService = (TestService) ctx.getBean("testService");

        db.model.Test test = new db.model.Test();
        test.setId("AB123");
        test.setAge(22);
        testService.modifyTest(test);
    }

    @Test
    public void TestSelect(){
        String[] paths = new String[] { "spring/applicationContext-bo.xml" };
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        TestService testService = (TestService) ctx.getBean("testService");

        db.model.Test test = new db.model.Test();
        test.setName("qjkobe");

        List<db.model.Test> list1 = testService.getTestListByParam(test);
        for(db.model.Test x : list1){
            System.out.println(x.getId() + ":" + x.getName() + ":" +x.getAge());
        }

        System.out.println("---------------");
        db.model.Test test2 = new db.model.Test();
        test2.setAge(21);

        List<db.model.Test> list2 = testService.getTestListByParam(test2);
        for(db.model.Test x : list2){
            System.out.println(x.getId() + ":" + x.getName() + ":" +x.getAge());
        }
    }
}
