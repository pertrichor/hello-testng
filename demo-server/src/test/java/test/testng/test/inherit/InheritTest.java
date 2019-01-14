package test.testng.test.inherit;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * Description: 继承测试
 *
 * 1. 由于所有testNG的测试方法都是public的 , 所以基类的测试方法很自然会被子类知晓并继承.
 * 2. 我们可以将一些共性的测试方法抽取到基类中完成 , 提高代码的复用率.
 * 3. 执行测试时 , 基类的方法不需要对外暴露.
 *
 * @author XuTao
 * @create 2019-01-14 7:57
 */
@Slf4j
public class InheritTest extends BaseTest {

    @Test(dataProvider = "uuidProvider")
    public void test(String uuid) {
        log.info(">> 测试方法执行 , uuid: {}", uuid);
    }

}
