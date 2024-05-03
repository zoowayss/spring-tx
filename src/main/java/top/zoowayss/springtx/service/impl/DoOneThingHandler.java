package top.zoowayss.springtx.service.impl;

import org.springframework.stereotype.Service;
import top.zoowayss.springtx.service.DoSomeThingHandler;

@Service
public class DoOneThingHandler implements DoSomeThingHandler {
    @Override
    public void doSomeThing() {
        log.info("do one thing");
    }
}
