package test.testng.test.annotation;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Description: ITest监听器
 *
 * @author XuTao
 * @create 2019-01-13 21:28
 */
@Slf4j
public class TestNGListener implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        log.info(">> Listener Event , onTestStart");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info(">> Listener Event , onTestSuccess");
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.info(">> Listener Event , onTestFailure");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.info(">> Listener Event , onTestSkipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log.info(">> Listener Event , onTestFailedButWithinSuccessPercentage");
    }

    public void onStart(ITestContext iTestContext) {
        log.info(">> Listener Event , onStart");
    }

    public void onFinish(ITestContext iTestContext) {
        log.info(">> Listener Event , onFinish");
    }
}
