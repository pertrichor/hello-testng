package test.testng.test.exceptionexpected;

/**
 * Description:自定义的受检异常
 *
 * @author XuTao
 * @create 2019-01-16 20:30
 */
public class CustomerCheckedException extends Exception {
    public CustomerCheckedException(String errorMsg) {
        super(errorMsg);
    }
}
