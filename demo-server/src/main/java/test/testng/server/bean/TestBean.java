package test.testng.server.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Description:用于测试的spring托管bean
 *
 * @author XuTao
 * @create 2019-01-23 19:47
 */
@Setter
@Getter
@Component
public class TestBean {

    private String name = "I'm a bean from spring context.";
}
