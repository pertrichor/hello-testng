package test.testng.test.run;

import org.testng.TestNG;

/**
 * Description: 执行测试
 *
 * @author XuTao
 * @create 2019-01-14 8:20
 */
public class TestRunner {

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[]{RunTest.class});
        testNG.run();
    }
}
