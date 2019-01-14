package test.testng.test.multithread;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * Description: 测试多线程
 * <p>
 * 1. @Test的invocationCount(执行次数)和threadPoolSize(执行线程池大小)配合使用可以模拟多线程并发环境.
 *
 * @author XuTao
 * @create 2019-01-13 23:53
 */
@Slf4j
public class MultiThreadTest {

    @Test(invocationCount = 100, threadPoolSize = 10)
    public void test() {
        Singleton singleton = Singleton.getInstance();
        log.info("Thread:{} , instance:{}", Thread.currentThread().getId(), singleton);
    }

    public static class Singleton {
        private static class InstanceHolder {
            private static final Singleton singleton = new Singleton();
        }

        public static Singleton getInstance() {
            return InstanceHolder.singleton;
        }
    }

}
