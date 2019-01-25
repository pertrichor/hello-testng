package test.testng.test.example;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
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
public class TestLogin extends BaseTest {

    @Test(dataProvider = "authInfoProvider", groups = {"test.login.auth"})
    public void testAuth(String param) {
        String result = HttpUtils.sendPost(BASE_SERVER_URL + "/login", param, null);
        Assert.assertNotNull(result);

        AuthController.AuthResultVO resultVO = JSON.parseObject(result, AuthController.AuthResultVO.class);
        Assert.assertNotNull(resultVO);

        log.info(">> 登录结果：{}，token：{}", resultVO.getResult(), resultVO.getToken());
        Reporter.log(String.format(">> 登录结果：%s，token：%s", resultVO.getResult(), resultVO.getToken()));

        token = resultVO.getToken();
        Assert.assertNotNull(token);
    }

    @Test(dependsOnGroups = {"test.login.auth"}, groups = {"test.login.userInfo"})
    public void testGetUserInfo() {
        Assert.assertNotNull(token);

        String result = HttpUtils.sendPost(BASE_SERVER_URL + "/getUserInfo", token, null);
        Assert.assertNotNull(result);

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
