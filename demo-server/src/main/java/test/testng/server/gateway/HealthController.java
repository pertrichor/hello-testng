package test.testng.server.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 健康监测
 *
 * @author XuTao
 * @create 2019-01-14 8:58
 */
@RestController
public class HealthController {

    @GetMapping("health")
    public String health() {
        return "I'm fine";
    }
}
