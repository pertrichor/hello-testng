package test.testng.server.gateway;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Description:模拟登陆
 *
 * @author XuTao
 * @create 2019-01-10 20:11
 */
@Slf4j
@RestController
public class AuthController {

    private static UserInfo[] REGISTERED_USERS = {
            new UserInfo("xiaoming", "xiaoming123", "小明", 23, "man", "3f462e0ae57145358f8ae90ddcabff96"),
            new UserInfo("xiaohong", "xiaohong123", "小红", 24, "woman", "d4379948115d4e52b1fd6c6cfaa209f6"),
            new UserInfo("xiaofang", "xiaofang123", "小芳", 25, "woman", "90c910cd3bb643f19dc1232a46828317"),
    };

    private static final Map<String, UserInfo> LOGIN_USERS = new HashMap<>();

    @PostMapping("/login")
    public AuthResultVO auth(@RequestBody String param) throws InterruptedException {
        JSONObject obj = JSON.parseObject(param);
        String username = obj.getString("username");
        String password = obj.getString("password");
        log.info(">> /login -> username: {} , password: {}", username, password);

        Thread.sleep(1000L);

        UserInfo loginUser = this.checkAuth(username, password);
        if (loginUser != null) {
            String token = UUID.randomUUID().toString().replace("-", "");
            LOGIN_USERS.put(token, loginUser);
            return new AuthResultVO("success", token);
        } else {
            return new AuthResultVO("fail", null);
        }
    }

    @PostMapping("/getUserInfo")
    public UserInfo getUserInfo(@RequestBody String token) {
        return LOGIN_USERS.get(token);
    }

    private UserInfo checkAuth(String username, String password) {
        for (UserInfo userInfo : REGISTERED_USERS) {
            if (userInfo.getUsername().equals(username) && userInfo.getPassword().equals(password)) {
                return userInfo;
            }
        }

        return null;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserInfo {
        private String username;
        @JSONField(serialize = false)
        private String password;
        private String nickname;
        private Integer age;
        private String gender;
        private String uid;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AuthResultVO {
        private String result;
        private String token;
    }
}
