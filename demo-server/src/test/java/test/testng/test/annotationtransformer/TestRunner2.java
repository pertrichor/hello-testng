package test.testng.test.annotationtransformer;

import org.testng.ITestNGListener;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:启动
 *
 * @author XuTao
 * @create 2019-01-17 19:59
 */
public class TestRunner2 {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[]{AnnotationTransformerTest2.class});
        List<Class<? extends ITestNGListener>> listeners = new ArrayList<>();
        listeners.add(MyAnnotationTransformer2.class);
        testNG.setListenerClasses(listeners);
        testNG.run();
    }
}
