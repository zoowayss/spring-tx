package top.zoowayss.springtx.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.zoowayss.springtx.service.LogService;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
     *
     * @return
     */
    @GetMapping
    public String get() {
        log.info("{}", cm());
        return "hello";
    }

    @PostMapping
    public Object post(@RequestBody Map<String, Object> map, @PathVariable("version") String ignore, HttpServletRequest request) {
        Map<String, Object> headers = new HashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            headers.put(header, request.getHeader(header));
        }
        map.put("Header", headers);
        return map;
    }
}
