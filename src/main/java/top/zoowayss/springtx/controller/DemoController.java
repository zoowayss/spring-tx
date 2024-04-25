package top.zoowayss.springtx.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zoowayss.springtx.entity.DemoEntity;
import top.zoowayss.springtx.event.domain.DemoUpdatedEvent;
import top.zoowayss.springtx.service.IDemoService;
import top.zoowayss.springtx.utils.UUIDUtils;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/4/19 16:26
 */
@RestController
@Slf4j
public class DemoController {

    @Resource
    private ApplicationEventPublisher eventPublisher;

    @Resource
    private IDemoService chargeOrderService;

    /**
     * sql 文件里面创建的 id
     */
    public static final long DEFAULT_ID = 1781245270718291969L;


    /**
     * 测试 事务状态下发布事件
     * <P></P>
     * curl -X GET "http://localhost:9999/test/event"
     *
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/test/event")
    @Transactional
    public String testEvent() throws InterruptedException {
        String cm = "testEvent@DemoController";
        String updateStr = UUIDUtils.randomUUID();
        DemoEntity update = new DemoEntity(DEFAULT_ID, 1, updateStr);
        chargeOrderService.updateById(update);
        Thread.sleep(3000L);

        log.info("{} update order success. data: {}", cm, update);
        eventPublisher.publishEvent(new DemoUpdatedEvent(this, "test1"));

        DemoEntity current = chargeOrderService.getById(DEFAULT_ID);
        log.info("{} query order success. data: {}", cm, current);
        return "testEvent";
    }


    /**
     * 这是有事务管理的
     */
    @Transactional
    @Scheduled(cron = "0/10 * * * * ?")
    public void testTask() {
        String updateStr = UUIDUtils.randomUUID();
        DemoEntity update = new DemoEntity(DEFAULT_ID, 1, updateStr);

        chargeOrderService.updateById(update);
        log.info("testTask update order success. updateStr: {}", updateStr);
        int i = 10 / 0;
    }
}
