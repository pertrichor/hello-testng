package test.testng.test.inherit;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.UUID;

/**
 * Description: 测试基类
 *
 * @author XuTao
 * @create 2019-01-14 7:56
 */
@Slf4j
public class BaseTest {

    @BeforeTest
    public void checkJDBC() throws InterruptedException {
        log.info(">> 检查jdbc连接..");
        Thread.sleep(1000L);
        log.info(">> jdbc连接正常..");
    }


    @AfterTest
    public void tearDown() throws InterruptedException {
        log.info(">> 测试结束 , 回滚测试数据..");
        Thread.sleep(1000L);
        log.info(">> 测试数据回滚完毕..");
    }

    @DataProvider(name = "uuidProvider")
    public Object[][] provideUUID() {
        return new Object[][]{
                {UUID.randomUUID().toString()}
        };
    }
}
