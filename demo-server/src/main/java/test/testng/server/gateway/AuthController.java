package test.testng.server.gateway;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:模拟登陆
 *
 * @author XuTao
 * @create 2019-01-10 20:11
 */
@Slf4j
@RestController
public class AuthController {

    @PostMapping("/auth")
    public String auth(@RequestBody String param) throws InterruptedException {
        JSONObject obj = JSON.parseObject(param);
        String username = obj.getString("username");
        String password = obj.getString("password");
        log.info(">> /auth -> username: {} , password: {}", username, password);
        Thread.sleep(1000L);
        return "success";
    }
}
