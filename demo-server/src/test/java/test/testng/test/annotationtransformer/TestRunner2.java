package test.testng.test.annotationtransformer;

import org.testng.TestNG;

import java.util.Arrays;

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
        testNG.setListenerClasses(Arrays.asList(MyAnnotationTransformer2.class));
        testNG.run();
    }
}
