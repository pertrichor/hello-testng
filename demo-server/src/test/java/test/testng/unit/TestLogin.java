package test.testng.unit;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.testng.server.gateway.AuthController;
import test.testng.server.utils.HttpUtils;

/**
 * Description:登录测试
 *
 * @author XuTao
 * @create 2019-01-11 09:36
 */
@Slf4j
public class TestLogin {

    private static final String BASE_URL = "http://localhost:8989";

    private static String token;

    @DataProvider(name = "authInfoProvider", parallel = true)
    public Object[][] provideAuthInfo() {
        return new Object[][]{
                {JSON.toJSONString(new AuthInfo("xiaoming", "xiaoming123"))}
        };
    }

    @Test(dataProvider = "authInfoProvider", groups = {"loginTestGroup"})
    public void testAuth(String param) {
        String result = HttpUtils.sendPost(BASE_URL + "/login", param, null);
        if (StringUtils.isBlank(result)) {
            log.info(">> 登录响应结果为空");
            return;
        }
        AuthController.AuthResultVO resultVO = JSON.parseObject(result, AuthController.AuthResultVO.class);
        if (resultVO == null) {
            log.info(">> 登录响应结果格式无法识别");
            return;
        }
        log.info(">> 登录结果：{}，token：{}", resultVO.getResult(), resultVO.getToken());
        Reporter.log(String.format(">> 登录结果：%s，token：%s", resultVO.getResult(), resultVO.getToken()));
        token = resultVO.getToken();
    }

    @Test(dependsOnMethods = "testAuth", groups = {"loginTestGroup"})
    public void testGetUserInfo() {
        if (StringUtils.isBlank(token)) {
            log.warn(">> 登录失败，无法获取用户信息");
        }

        String result = HttpUtils.sendPost(BASE_URL + "/getUserInfo", token, null);
        if (StringUtils.isBlank(result)) {
            log.warn(">> 没有获取到用户信息");
            return;
        }

        log.info(">> 获取到用户信息，userInfo: {}", result);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthInfo {
        private String username;
        private String password;
    }
}
