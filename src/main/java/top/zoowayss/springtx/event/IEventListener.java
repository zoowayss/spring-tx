package top.zoowayss.springtx.event;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import top.zoowayss.springtx.controller.DemoController;
import top.zoowayss.springtx.entity.DemoEntity;
import top.zoowayss.springtx.event.domain.DemoUpdatedEvent;
import top.zoowayss.springtx.service.IDemoService;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/4/19 16:24
 */
@Component
@Slf4j
public class IEventListener {

    @Resource
    private IDemoService chargeOrderService;

    @Async
    @EventListener
    public void onDemoUpdated(DemoUpdatedEvent event) {
        DemoEntity service = chargeOrderService.getById(DemoController.DEFAULT_ID);
        log.info("onRegisterUser: {} order content: {}", event, service.getContent());
    }
}
