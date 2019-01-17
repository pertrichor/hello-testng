package test.testng.test.ignore;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * Description:使用@Ignore注解忽略测试
 *
 * @author XuTao
 * @create 2019-01-17 15:12
 */
@Slf4j
@Ignore
public class IgnoreTest2 {

    @Test
    public void test() {
        log.info(">> test run..");
    }
}
