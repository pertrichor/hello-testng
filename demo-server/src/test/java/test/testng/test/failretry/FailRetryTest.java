package test.testng.test.failretry;

import org.testng.annotations.Test;

/**
 * Description:失败重试测试
 *
 * @author XuTao
 * @create 2019-01-17 18:44
 */
public class FailRetryTest {

    @Test
    public void test() {
        assert false;
    }

}
