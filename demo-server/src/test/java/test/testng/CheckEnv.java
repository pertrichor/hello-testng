package test.testng;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

/**
 * Description:检查系统环境
 *
 * @author XuTao
 * @create 2019-01-10 20:26
 */
@Slf4j
public class CheckEnv {

    @BeforeSuite(alwaysRun = true)
    public void checkEnv() {
        Properties properties = System.getProperties();
        String runtimeJava = properties.getProperty("java.runtime.name");
        String javaVersion = properties.getProperty("java.specification.version");
        String classpath = properties.getProperty("java.class.path");
        String javaLibPath = properties.getProperty("java.library.path");
        String javaVmVersion = properties.getProperty("java.vm.version");
        String javaVmName = properties.getProperty("java.vm.name");
        String osArch = properties.getProperty("os.arch");
        String osName = properties.getProperty("os.name");
        String sumJnuEncoding = properties.getProperty("sun.jnu.encoding");
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
        log.info(">> sumJnuEncoding: [{}]", sumJnuEncoding);
        log.info(">> fileEncoding: [{}]", fileEncoding);
        log.info(">> timezone: [{}]", timezone);
//        log.info(">> javaLibPath: {}", javaLibPath);
//        log.info(">> classpath: {}", classpath);
        log.info("===================================================");
    }

}
