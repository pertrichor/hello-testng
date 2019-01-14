package test.testng.test.parameter;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Description: 为测试方法提供参数
 * <p>
 * 1. @Parameters的值来自于testng.xml中定义的常量值.
 * 2. @DataProvider提供动态生成的参数值.
 * 3. 如果测试方法的参数值为单个常量值 , 且是基本数据类型 , 用@Parameters更方便. 如果测试方法的参数值有多个 , 或者类型不是基本数据类型 , 此时可以使用@DataProvider.
 * 4. 使用@Factory也可以注入参数 , 参考test.testng.test.factory案例.
 * 5. @DataProvider必须返回Object[][]或Iterator<Object[]> , 使用后者时 , 参数是在测试方法调用前才实例化参数涉及到的对象.
 * 6. @DataProvider返回的Object[][]的第一个维度代表测试要执行的次数. 在此测试类中 , 返回了两个Object[] , 所以test2方法会执行两次.
 * 7. @DataProvider标注的方法可以注入两种类型的参数.
 * 7.1 Method:当前需要提供数据的测试方法的Method对象 , 这使我们可以判断是否需要为不同的测试方法起用不同的数据提供逻辑.
 * 7.2 ITestContext:当前测试的上下文 , 这使得数据提供逻辑可以根据当前测试的上下文内容做出改变.
 * 8. @DataProvider中属性值parallel = true时 , testNG会并行执行provide方法 , 但会保证在test2执行前完成.
 * 9. @Test如果设置了dataProviderClass属性 , testNG仅在指定的class中根据dataProvider属性值查找对应的数据提供者 , 查找失败会抛出异常.
 *
 * @author XuTao
 * @create 2019-01-13 23:19
 */
@Slf4j
public class ParameterTest {

    @Parameters("paramFromXml")
    @Test
    public void test1(String param) {
        log.info(">> Param from xml is {}", param);
    }

    @Test(dataProvider = "dataProvider")
    public void test2(ParamDto dto) {
        log.info(">> Param from dataProvider is [{}]", JSON.toJSONString(dto));
    }

    @DataProvider(name = "dataProvider", parallel = true)
    public Object[][] provide(Method method) {
        log.info(">> 为测试方法 [{}] 生成测试参数", method.getName());

        return new Object[][]{
                {new ParamDto("小明", "男", 22)},
                {new ParamDto("小红", "女", 20)},
        };
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ParamDto {
        // 参数1
        private String param1;
        // 参数2
        private String param2;
        // 参数3
        private Integer param3;
    }
}
