package test.testng.test.ignore;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * Description:忽略测试
 * 1. 使用@Test属性enable=false来禁用此测试.
 * 2. 将测试添加到忽略测试组 , 在testng.xml中排除它.
 * 3. 使用@Ignore注解。注意要升级到最新版本，旧版本没有此注解。
 *
 * @author XuTao
 * @create 2019-01-14 09:59
 */
@Slf4j
@Test
public class IgnoreTest {

    @Test
    public void test1() {
        log.info("test1 run..");
    }

    @Test(enabled = false)
    public void test2() {
        log.info("test2 run..");
    }

    @Test(groups = {"test.ignore"})
    public void test3() {
        log.info("test3 run..");
    }
}
