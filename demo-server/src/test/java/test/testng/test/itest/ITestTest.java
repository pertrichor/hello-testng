package test.testng.test.itest;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITest;
import org.testng.annotations.Test;

/**
 * Description: ITest接口
 * <p>
 * 实现此接口的getTestName方法 , 返回值会进入最后生成的测试报告中.
 *
 * @author XuTao
 * @create 2019-01-13 23:13
 */
@Slf4j
public class ITestTest implements ITest {

    @Test
    public void test() {
        log.info(">> 测试执行");
    }

    @Override
    public String getTestName() {
        return "我是一个自定义的方法名";
    }
}
