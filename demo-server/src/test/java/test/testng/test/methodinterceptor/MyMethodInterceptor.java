package test.testng.test.methodinterceptor;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

import java.util.*;

/**
 * Description:方法拦截器
 *
 * @author XuTao
 * @create 2019-01-18 13:32
 */
public class MyMethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        List<IMethodInstance> result = new ArrayList<>();

        for (IMethodInstance methodInstance : list) {
            ITestNGMethod method = methodInstance.getMethod();
            Set<String> groups = new HashSet<>();

            if (method.isTest()) {//如果是@Test注解
                Collections.addAll(groups, method.getGroups());
            }

            if (groups.contains("test.group1")) {// 只运行test.group1组测试
                result.add(methodInstance);
            }
        }

        return result;
    }
}
