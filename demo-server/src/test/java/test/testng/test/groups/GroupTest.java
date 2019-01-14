package test.testng.test.groups;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * Description: 测试组
 * <p>
 * 1. @Test加在类上并指定groups属性 , 类中所有方法都归属此组.
 * 2. 一个测试类或一个测试方法可以归属多个测试组.
 * 3. 组的命名:
 * 测试类型:单元测试、集成测试
 * 测试规模:小规模、大规模
 * 功能描述:数据库、界面
 * 测试速度:慢测试、快测试
 * 过程描述:冒烟测试、发布测试
 * 等.
 * <p>
 * 格式: 使用 database.table.t_user 的格式 , 可以在配置测试时 , 使用 database.* 这样的正则方便得指定测试范围.
 *
 * @author XuTao
 * @create 2019-01-13 22:27
 */
@Slf4j
@Test(groups = {"testGroup1"})
public class GroupTest {

    @Test(groups = {"testGroup2", "testGroup3"})
    public void test1() {
        log.info(">> test1 run..");
    }

    @Test(groups = {"testGroup2"})
    public void test2() {
        log.info(">> test2 run..");
    }

    @Test
    public void test3() {
        log.info(">> test3 run..");
    }
}
