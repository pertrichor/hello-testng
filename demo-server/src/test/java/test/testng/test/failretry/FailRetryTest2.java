package test.testng.test.failretry;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Description:错误重试测试
 *
 * @author XuTao
 * @create 2019-01-17 19:18
 */
@Slf4j
public class FailRetryTest2 {

    private static int failCount = 0;

    @Test(retryAnalyzer = MyRetryAnalyzer.class)
    public void test() {
        failCount++;
        log.info(">> 第{}次执行..", failCount);
        if (failCount < 4) {
            Assert.fail();
        }
    }
}
