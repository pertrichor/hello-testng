package test.testng.test.failretry;

import lombok.extern.slf4j.Slf4j;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Description:重试分析器
 *
 * @author XuTao
 * @create 2019-01-17 19:14
 */
@Slf4j
public class MyRetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_RETRY_COUNT = 3;
    private static int currentRetryCount = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentRetryCount < MAX_RETRY_COUNT) {
            currentRetryCount++;
            log.info(">> 第{}次重试", currentRetryCount);
            return true;
        }
        log.info(">> 不再重试", currentRetryCount);
        return false;
    }
}
