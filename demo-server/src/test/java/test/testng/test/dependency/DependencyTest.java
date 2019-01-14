package test.testng.test.dependency;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * Description: 依赖测试
 * 1. 通过dependsOnMethods或dependsOnGroups属性 , 可以使测试方法依赖于另一个或一组测试方法. 被依赖的方法总在之前执行.
 * 2. dependsOnMethods的弊端: 值为方法名 , 如果对测试方法重命名 , 则依赖关系失效. 如果新增了被依赖的测试方法 , 则可能需要在多处添加新的方法名.
 * 3. 使用dependsOnGroups可以避免上述问题 , 伸缩性更好 , 不违反DRY原则.
 * 4. 依赖分为强依赖和弱依赖 , 此类中即为强依赖 , 如果被依赖的方法执行失败 , 依赖它的方法将被标记为SKIP , 不会执行.
 * 5. 通过设置@Test的属性 alwaysRun = true , 将依赖变为弱依赖. 即时被依赖方法执行失败 , 此测试方法依然会执行.
 *
 * @author XuTao
 * @create 2019-01-14 0:01
 */
@Slf4j
public class DependencyTest {

    @Test
    public void test1() {
        log.info(">> test1 run..");
    }

    @Test(groups = {"group1"})
    public void test2() {
        log.info(">> test2 run..");
    }

    @Test(dependsOnMethods = {"test1"})
    public void test3() {
        log.info(">> test3 run..");
    }

    @Test(dependsOnGroups = {"group1"})
    public void test4() {
        log.info(">> test4 run..");
    }
}
