package test.testng.test.parallel;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * Description:并行测试
 * <p>
 * 通过指定testng.xml中suite/test标签的属性parallel值，控制测试在何种粒度下采用并行模式。
 *
 * @author XuTao
 * @create 2019-01-17 16:43
 */
@Slf4j
@Test
public class ParallelTest {

    public void test1() {
        log.info(">> test1 run.. , threadId: {}", Thread.currentThread().getId());
    }

    public void test2() {
        log.info(">> test2 run.. , threadId: {}", Thread.currentThread().getId());
    }

    public void test3() {
        log.info(">> test3 run.. , threadId: {}", Thread.currentThread().getId());
    }

    public void test4() {
        log.info(">> test4 run.. , threadId: {}", Thread.currentThread().getId());
    }

    public void test5() {
        log.info(">> test5 run.. , threadId: {}", Thread.currentThread().getId());
    }
}
