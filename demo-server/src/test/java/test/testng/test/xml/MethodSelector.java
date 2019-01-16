package test.testng.test.xml;

import org.testng.IMethodSelector;
import org.testng.IMethodSelectorContext;
import org.testng.ITestNGMethod;

import java.util.List;

/**
 * Description:方法选择器
 *
 * @author XuTao
 * @create 2019-01-16 11:32
 */
public class MethodSelector implements IMethodSelector {
    @Override
    public boolean includeMethod(IMethodSelectorContext iMethodSelectorContext, ITestNGMethod iTestNGMethod, boolean b) {
        return false;
    }

    @Override
    public void setTestMethods(List<ITestNGMethod> list) {

    }
}
