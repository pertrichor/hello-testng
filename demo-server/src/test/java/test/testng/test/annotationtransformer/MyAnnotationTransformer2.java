package test.testng.test.annotationtransformer;

import org.testng.IAnnotationTransformer2;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Description:IAnnotationTransformer2实现类
 * <p>
 * 可以在运行期间改变@Test注解周围的其他注解的配置，例如@DataProvider。
 *
 * @author XuTao
 * @create 2019-01-14 10:24
 */
public class MyAnnotationTransformer2 implements IAnnotationTransformer2 {
    @Override
    public void transform(IConfigurationAnnotation iConfigurationAnnotation, Class aClass, Constructor constructor, Method method) {
        // @Configuration已过期，不做演示
    }

    @Override
    public void transform(IDataProviderAnnotation iDataProviderAnnotation, Method method) {
        if (iDataProviderAnnotation.getName().equals("dp2")) {
            iDataProviderAnnotation.setParallel(true);
        }
    }

    @Override
    public void transform(IFactoryAnnotation iFactoryAnnotation, Method method) {
        iFactoryAnnotation.setDataProvider("dp2");
    }

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        // 同IAnnotationTransformer的transform方法
    }
}
