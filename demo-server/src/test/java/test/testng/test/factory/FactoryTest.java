package test.testng.test.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Description: 测试实例工厂
 * <p>
 * 1. @Factory用来动态生成测试类实例 , 可以通过成员变量注入可变参数.
 * 2. @Factory可以使用@DataProvider来提供数据.
 * 3. @Factory和@DataProvider都可以为测试方法提供动态生成的参数 , 较优的选择是 , 当测试类中的测试方法都需要使用成员变量时 , 使用@Factory更方便. 如果每个测试方法参数都不一样 , 使用@DataProvider更合适.
 * 4. @Factory的方法必须由public修饰.
 * 5. @Factory标注的方法只会被执行一次 , 在本测试中 , @Factory方法在测试类中 , 但执行测试类并不会多次执行@Factory方法.
 * 6. 如果测试类中有没有被执行过的@Factory方法 , 那么会执行@Factory方法 , 再继续执行生成的测试类 , 直到测试类中不再包含@Factory方法或不再包含还未执行过的@Factory方法.
 *
 * @author XuTao
 * @create 2019-01-13 22:47
 */
@Slf4j
@Setter
@Getter
@AllArgsConstructor
public class FactoryTest {

    private String var1;

    @Test
    public void test() {
        log.info(">> 接收到的参数为: {}", var1);
    }

    @Factory(dataProvider = "factoryDataProvider")
    public Object[] createTest(String[] paramArr) {
        return Stream.of(paramArr).map(FactoryTest::new).collect(toList()).toArray();
    }

    @DataProvider(name = "factoryDataProvider")
    public Iterator<Object[]> provide() {
        List<Object[]> paramList = new ArrayList<>();
        paramList.add(new Object[]{new String[]{"测试1", "测试2", "测试3"}});
        paramList.add(new Object[]{new String[]{"测试4", "测试5", "测试6"}});
        return paramList.iterator();
    }
}
