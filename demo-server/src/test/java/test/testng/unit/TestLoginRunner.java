package test.testng.unit;

import org.testng.TestNG;

/**
 * Description:testng启动类
 *
 * @author XuTao
 * @create 2019-01-11 11:32
 */
public class TestLoginRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[]{TestLogin.class});
        testNG.run();
    }
}
