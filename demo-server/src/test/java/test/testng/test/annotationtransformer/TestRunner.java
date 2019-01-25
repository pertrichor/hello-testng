package test.testng.test.annotationtransformer;

import org.testng.TestNG;

import java.util.Arrays;

/**
 * Description:启动
 *
 * @author XuTao
 * @create 2019-01-17 19:59
 */
public class TestRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[]{AnnotationTransformerTest.class});
        testNG.setListenerClasses(Arrays.asList(MyAnnotationTransformer.class));
        testNG.run();
    }
}
