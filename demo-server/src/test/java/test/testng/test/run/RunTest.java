package test.testng.test.run;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * Description: 运行测试
 * <p>
 * 1. 直接右键testng.xml运行.
 * 2. 通过java编码运行. 编码方式支持定义虚拟的testng.xml
 * 3. 打jar包 , 使用命令行命令运行. 命令行运行参数见官方文档.
 * 4. 使用maven-surefire-plugin插件执行.
 * <p>
 * 此处开发人员使用第一或第二种最为方便 , 前提是安装了IDEA的TestNG-J插件.
 *
 * @author XuTao
 * @create 2019-01-14 8:19
 */
@Slf4j
public class RunTest {

    @Test
    public void test() {
        log.info(">> 测试执行..");
    }

}
