package top.zoowayss.springtx.controller;

import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zoowayss.springtx.service.IDemoService;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/9/13 09:30
 */
@RequestMapping("/v1/demo")
@RestController
public class DemoController {


    @Resource
    private IDemoService demoService;


    /**
     * 测试抛异常回滚
     *
     * @return
     */
    @GetMapping("/tx1")
    @Transactional
    public Object test() {
        demoService.changeOrderStatusTo2();
        return "OK";

    }

}
