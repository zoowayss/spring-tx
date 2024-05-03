package top.zoowayss.springtx.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.zoowayss.springtx.service.DoSomeThingHandler;

@Service
@Slf4j
public class DoSecondThingHandlerImpl implements DoSomeThingHandler {
    @Override
    public void doSomeThing() {
        log.info("do second thing");
    }
}
