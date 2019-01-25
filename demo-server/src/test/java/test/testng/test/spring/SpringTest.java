package test.testng.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import test.testng.server.Application;
import test.testng.server.bean.TestBean;

/**
 * Description:测试与Spring集成
 *
 * @author XuTao
 * @create 2019-01-23 19:52
 */
@Test
//@ContextConfiguration(value = {"classpath:spring-test-config.xml"})
@SpringBootTest(classes = {Application.class})
public class SpringTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestBean testBean;

    @Test
    public void test() {
        System.out.println(testBean.getName());
    }
}
