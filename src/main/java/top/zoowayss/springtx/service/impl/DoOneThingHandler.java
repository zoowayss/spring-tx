package top.zoowayss.springtx.service.impl;

import org.springframework.stereotype.Service;
import top.zoowayss.springtx.service.AbstractDoSomeHandler;
import top.zoowayss.springtx.service.DoSomeThingHandler;
import top.zoowayss.springtx.service.XXService;

import javax.swing.*;

@Service
public class DoOneThingHandler extends AbstractDoSomeHandler implements XXService {
    @Override
    public void doSomeThing() {
        log.info("do one thing");
    }
}
