package test.testng;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeSuite;

/**
 * Description:启动测试前预热应用
 *
 * @author XuTao
 * @create 2019-01-10 20:26
 */
@Slf4j
public class WarmUp {

    @BeforeSuite
    public void warmUp() {
        log.info(">> warm up");
    }

}
