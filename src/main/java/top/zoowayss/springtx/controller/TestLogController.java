package top.zoowayss.springtx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zoowayss.springtx.service.LogService;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/5/16 16:43
 */
@RestController
@RequestMapping("/{version}/log")
@Slf4j
public class TestLogController implements LogService {


    /**
     * curl -X GET http://localhost:9999/v1/log
     * @return
     */
    @GetMapping
    public String get() {
        log.info("{}", cm());
        return "hello";
    }
}
