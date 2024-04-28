package top.zoowayss.springtx.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.zoowayss.springtx.service.DoSomeThingHandler;

import java.util.Collections;
import java.util.List;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/4/28 14:12
 */
@Service
@Slf4j
public class DoSomeThingHandlerImpl implements DoSomeThingHandler {
    @Override
    public List<String> getSomeThing() {
        log.info("getSomeThing@DoSomeThingHandlerImpl: get Hello World");
        return Collections.singletonList("Hello World");
    }
}
