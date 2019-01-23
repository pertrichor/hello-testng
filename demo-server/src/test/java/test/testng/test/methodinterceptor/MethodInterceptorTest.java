package test.testng.test.methodinterceptor;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Description:方法拦截器测试
 *
 * @author XuTao
 * @create 2019-01-18 13:29
 */
@Slf4j
@Listeners({MyMethodInterceptor.class})
public class MethodInterceptorTest {

    @Test(groups = {"test.group1"})
    public void test1() {
        log.info(">> test1 run..");
    }

    @Test(groups = {"test.group2"})
    public void test2() {
        log.info(">> test2 run..");
    }

    @Test(groups = {"test.group3"})
    public void test3() {
        log.info(">> test3 run..");
    }
}
