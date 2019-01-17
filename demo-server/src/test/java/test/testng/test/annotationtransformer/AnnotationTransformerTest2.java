package test.testng.test.annotationtransformer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Description:注解转换器测试2
 *
 * @author XuTao
 * @create 2019-01-17 19:57
 */
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class AnnotationTransformerTest2 {

    private String var;

    @Test
    public void test() {
        log.info("test run.. var: {}", var);
    }

    @Factory(dataProvider = "dp1")
    public Object[] create(String var) {
        return new AnnotationTransformerTest2[]{new AnnotationTransformerTest2(var)};
    }

    @DataProvider(name = "dp1")
    public Object[][] dp1() {
        return new Object[][]{
                new String[]{"data from dp1"}
        };
    }

    @DataProvider(name = "dp2")
    public Object[][] dp2() {
        return new Object[][]{
                new String[]{"data from dp2"}
        };
    }
}
