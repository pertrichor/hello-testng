package test.testng.test.annotation;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Description: 注解演示
 *
 * @author XuTao
 * @create 2019-01-13 20:55
 */
@Slf4j
@Setter
@Getter
@AllArgsConstructor
@Listeners({TestNGListener.class})
public class AnnotationTest {

    private String var;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        log.info(">> @BeforeSuite run..");
    }

    @AfterSuite
    public void afterSuite() {
        log.info(">> @AfterSuite run..");
    }

    @BeforeClass
    public void beforeClass() {
        log.info(">> @BeforeClass run..");
    }

    @AfterClass
    public void afterClass() {
        log.info(">> @AfterClass run..");
    }

    @BeforeTest
    public void beforeTest() {
        log.info(">> @BeforeTest run..");
    }

    @AfterTest
    public void afterTest() {
        log.info(">> @AfterTest run..");
    }

    @BeforeGroups(value = "testGroup")
    public void beforeGroups() {
        log.info(">> @BeforeGroups run..");
    }

    @AfterGroups(value = "testGroup")
    public void afterGroups() {
        log.info(">> @AfterGroups run..");
    }

    @BeforeMethod
    public void beforeMethod() {
        log.info(">> @BeforeMethod run..");
    }

    @AfterMethod
    public void afterMethod() {
        log.info(">> @AfterMethod run..");
    }

    @DataProvider(name = "testDataProvider")
    public Object[][] dataProvider(Method method) {
        log.info(">> 为方法 [ {} ] 注入参数", method.getName());
        return new Object[][]{
                {"Tom", "13861543024"},
                {"Jerry", "17654897651"},
        };
    }

    @Parameters({"parameter"})
    @Test(groups = "testGroup")
    public void testWithParameter(String parameter) {
        log.info(">> 测试方法 [testWithParameter] 执行 , 参数: {}", parameter);
    }

    @Test(dataProvider = "testDataProvider")
    public void testWithDataProvider(String name, String phoneNum) {
        log.info(">> 测试方法 [testWithDataProvider] 执行 , 参数: {} - {}", name, phoneNum);
    }

    @Test
    public void testWithPrivateField() {
        log.info(">> 测试方法 [testWithPrivateField] 执行 , 成员变量: {}", var);
    }

    @Factory()
    public Object[] factory() {
        Object[] testObjArr = new Object[2];
        int count = 0;
        while (count < 2) {
            testObjArr[count] = new AnnotationTest("count is " + count);
            count++;
        }
        log.info(">> 生成测试类实例数组: {}", JSON.toJSONString(testObjArr));
        return testObjArr;
    }
}
