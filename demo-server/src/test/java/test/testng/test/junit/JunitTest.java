package test.testng.test.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.testng.server.Application;
import test.testng.server.bean.TestBean;

/**
 * Description:JUnitTest
 *
 * @author XuTao
 * @create 2019-01-23 19:44
 */
@SpringBootTest(classes = {Application.class})
@RunWith(SpringRunner.class)
public class JunitTest {

    @Autowired
    private TestBean testBean;

    @Test
    public void test() {
        System.out.println(testBean.getName());
    }

}
