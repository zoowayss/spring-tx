package top.zoowayss.springtx.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zoowayss.springtx.entity.DemoEntity;
import top.zoowayss.springtx.event.domain.DemoUpdatedEvent;
import top.zoowayss.springtx.service.DoSomeThingHandler;
import top.zoowayss.springtx.service.IDemoService;
import top.zoowayss.springtx.utils.UUIDUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    private IDemoService demoService;

    @Resource
    private List<DoSomeThingHandler> doSomeThingHandlers;

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
        demoService.updateById(update);
        Thread.sleep(3000L);

        log.info("{} update order success. data: {}", cm, update);
        eventPublisher.publishEvent(new DemoUpdatedEvent(this, "test1"));

        DemoEntity current = demoService.getById(DEFAULT_ID);
        log.info("{} query order success. data: {}", cm, current);
        return "testEvent";
    }


    /**
     * 这是有事务管理的
     */
    @Transactional
//    @Scheduled(cron = "0/10 * * * * ?")
    public void testTask() {
        String updateStr = UUIDUtils.randomUUID();
        DemoEntity update = new DemoEntity(DEFAULT_ID, 1, updateStr);

        demoService.updateById(update);
        log.info("testTask update order success. updateStr: {}", updateStr);
        int i = 10 / 0;
    }

    /**
     * 测试默认接口方法<p></p>
     * curl -X GET "http://localhost:9999/test/default/interface"
     */
    @GetMapping("/test/default/interface")
    public void testDefaultInterface() {
        doSomeThingHandlers.forEach(DoSomeThingHandler::doSomeThing);

        log.info("==================================================");
        doSomeThingHandlers.forEach(DoSomeThingHandler::getSomeThing);
    }


    /**
     * 测试空字符串的 emails 属性<p></p>
     * 结果：<p></>
     * 会直接写入 '' 空字符串，而不是 null
     * curl -X GET "http://localhost:9999/test/empty/emails"
     */
    @GetMapping("/test/empty/emails")
    public void testEmptyEmails() {
        DemoEntity save = new DemoEntity(null, 1, UUIDUtils.randomUUID(), String.join(",", Collections.emptyList()));
        demoService.save(save);
    }


    @GetMapping("/test/url")
    public String testQueryUrl(HttpServletRequest request) {
        return request.getRequestURL() +"?"+ request.getQueryString();
    }


}
