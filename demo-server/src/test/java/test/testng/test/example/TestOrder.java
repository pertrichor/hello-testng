package test.testng.test.example;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.testng.server.gateway.HotelOrderController;
import test.testng.server.utils.HttpUtils;

/**
 * Description: 测试预定酒店
 *
 * @author XuTao
 * @create 2019-01-14 8:56
 */
@Slf4j
public class TestOrder extends BaseTest {

    private HotelOrderController.LockHotelVO lockHotel;

    @Parameters("hotelId")
    @Test(dependsOnGroups = {"test.login"}, groups = {"test.order.lock"}, alwaysRun = true)
    public void testOrder(String hotelId) {
        String lockResult = HttpUtils.sendPost(BASE_SERVER_URL + "hotel/lock", hotelId, null);
        log.info(">> 尝试锁定酒店 , 结果: {}", lockResult);
        lockHotel = JSON.parseObject(lockResult, HotelOrderController.LockHotelVO.class);
    }

    @Test(dependsOnGroups = {"test.order.lock"}, groups = {"test.order.book"})
    public void testBook() {
        String bookResult = HttpUtils.sendPost(BASE_SERVER_URL + "hotel/book", lockHotel.getOrderId(), null);
        log.info(">> 预定结果: {}", bookResult);
    }

    @AfterTest(groups = {"test.order"})
    public void tearDown() {
        String result = HttpUtils.sendPost(BASE_SERVER_URL + "hotel/cancel", lockHotel.getOrderId(), null);
        log.info(">> 取消订单 , 结果: {}", result);
    }
}
