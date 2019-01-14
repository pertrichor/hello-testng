package test.testng.test.listener;

import org.testng.IAnnotationTransformer2;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Description:IAnnotationTransformer2
 * <p>
 * 可以在运行期间改变@Test注解周围的其他注解。
 *
 * @author XuTao
 * @create 2019-01-14 10:24
 */
public class IAnnotationTransformer2Impl implements IAnnotationTransformer2 {
    @Override
    public void transform(IConfigurationAnnotation iConfigurationAnnotation, Class aClass, Constructor constructor, Method method) {

    }

    @Override
    public void transform(IDataProviderAnnotation iDataProviderAnnotation, Method method) {

    }

    @Override
    public void transform(IFactoryAnnotation iFactoryAnnotation, Method method) {

    }

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {

    }
}
