package test.testng.test.exceptionexpected;

import org.testng.annotations.Test;

/**
 * Description: 测试预期的异常
 * <p>
 * 当设置了预期出现的异常 , 测试方法抛出此异常时测试不会被标记为失败.
 * 可以同时指定抛出异常应该携带的错误信息 , 如果错误信息不匹配 , 此异常不会被忽略.
 *
 * @author XuTao
 * @create 2019-01-13 22:37
 */
public class ExceptionExpectedTest {

    @Test(expectedExceptions = {RuntimeException.class})
    public void test1() {
        throw new RuntimeException("预期出现的异常");
    }

    @Test(expectedExceptions = {RuntimeException.class}, expectedExceptionsMessageRegExp = "error")
    public void test2() {
        throw new RuntimeException("error");
//        throw new RuntimeException("exception");
    }
}
