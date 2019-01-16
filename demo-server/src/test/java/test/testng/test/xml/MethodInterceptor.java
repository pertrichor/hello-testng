package test.testng.test.xml;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.List;

/**
 * Description:方法拦截器
 *
 * @author XuTao
 * @create 2019-01-16 14:50
 */
public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        return null;
    }
}
