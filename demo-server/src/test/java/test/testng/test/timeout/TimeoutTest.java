package test.testng.test.timeout;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * Description: 超时测试
 * 1. @Test的属性timeOut可以标识这个方法完成的超时时间 , 配合invocationCount(执行次数) , successPercentage(成功次数占比) , 可以完成对接口/查询sql等响应速度的测试.
 *
 * @author XuTao
 * @create 2019-01-13 23:45
 */
@Slf4j
public class TimeoutTest {

    @Test(timeOut = 1000L)
    public void test() throws InterruptedException {
        Thread.sleep(2000L);
    }

    @Test(timeOut = 3000L, invocationCount = 5, successPercentage = 30)
    public void test1() throws InterruptedException {
        int second = (int) Math.round(Math.random() * 4);
        log.info(">> second: {}", second);
        Thread.sleep(second * 1000L);
    }
}
