package test.testng.test.example;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import test.testng.server.utils.HttpUtils;

import java.sql.Connection;
import java.util.Properties;

/**
 * Description:测试基类
 *
 * @author XuTao
 * @create 2019-01-10 20:26
 */
@Slf4j
public class BaseTest {

    protected static String BASE_SERVER_URL = "http://localhost:8989/";

    protected static String token = "947a6e127cb245f9a462d533e7a61af2";

    @BeforeSuite(alwaysRun = true)
    public void printEnv() {
        Properties properties = System.getProperties();
        String runtimeJava = properties.getProperty("java.runtime.name");
        String javaVersion = properties.getProperty("java.specification.version");
        String javaVmVersion = properties.getProperty("java.vm.version");
        String javaVmName = properties.getProperty("java.vm.name");
        String osArch = properties.getProperty("os.arch");
        String osName = properties.getProperty("os.name");
        String timezone = properties.getProperty("user.timezone");
        String fileEncoding = properties.getProperty("file.encoding");
        log.info("===================================================");
        log.info(">> 当前系统环境参数");
        log.info(">> javaVersion: [{}]", javaVersion);
        log.info(">> javaVmVersion: [{}]", javaVmVersion);
        log.info(">> runtimeJava: [{}]", runtimeJava);
        log.info(">> javaVmName: [{}]", javaVmName);
        log.info(">> osName: [{}]", osName);
        log.info(">> osArch: [{}]", osArch);
        log.info(">> fileEncoding: [{}]", fileEncoding);
        log.info(">> timezone: [{}]", timezone);
        log.info("===================================================");
    }

    @BeforeTest
    public void checkServer() {
        // 检查服务
        String result = HttpUtils.sendGet(BASE_SERVER_URL + "health", null);
        if (StringUtils.isBlank(result) || !StringUtils.equals("I'm fine", result)) {
            throw new RuntimeException("服务状态检测失败");
        }
    }

    @DataProvider(name = "authInfoProvider", parallel = true)
    public Object[][] provideAuthInfo() {
        return new Object[][]{
                {JSON.toJSONString(new TestLogin.AuthInfo("xiaoming", "xiaoming123"))}
        };
    }
}
