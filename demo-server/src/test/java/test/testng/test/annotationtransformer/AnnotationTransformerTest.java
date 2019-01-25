package test.testng.test.annotationtransformer;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * Description:注解转换器测试
 *
 * @author XuTao
 * @create 2019-01-17 19:57
 */
@Slf4j
public class AnnotationTransformerTest {

    @Test(invocationCount = 2)
    public void test() {
        log.info("test run..");
    }

    @Test
    public void test2() {
        log.info("test2 run..");
    }
}
