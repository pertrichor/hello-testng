package test.testng.test.listener;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Description:IAnnotationTransformer
 * <p>
 * 可以在运行过程中动态改变testNG注解的属性配置。
 *
 * @author XuTao
 * @create 2019-01-14 10:20
 */
public class IAnnotationTransformerImpl implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setAlwaysRun(true);
        iTestAnnotation.setInvocationCount(10);
    }
}
