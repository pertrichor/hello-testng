package test.testng.server.gateway;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * Description: 模拟酒店订单
 *
 * @author XuTao
 * @create 2019-01-14 8:31
 */
@Slf4j
@RestController
@RequestMapping("/hotel")
public class HotelOrderController {

    @PostMapping("/lock")
    public LockHotelVO lock(@RequestBody String orderInfo) throws InterruptedException {
        log.info(">> 订单信息: {}", orderInfo);
        // todo 从酒店未预定资源池中获取一条 , 并标记为锁定
        Thread.sleep(1000L);
        return new LockHotelVO(UUID.randomUUID().toString(), new Date(), 15 * 60 * 1000L);
    }

    @PostMapping("/book")
    public String book(@RequestBody String orderId) throws InterruptedException {
        log.info(">> 确认订单 , orderId: {}", orderId);
        // todo 此处保存新订单
        Thread.sleep(1000L);
        return "success";
    }

    @PostMapping("/cancel")
    public String cancel(String orderId) {
        log.info(">> 取消订单 , orderId: {}", orderId);
        // todo 此处取消订单 , 释放订单锁
        return "success";
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LockHotelVO {
        private String orderId;
        private Date bookTime;
        private Long expire;
    }
}
