package top.zoowayss.springtx.service;

import org.slf4j.Logger;

import java.util.Collections;
import java.util.List;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/4/28 14:10
 */

public interface DoSomeThingHandler {

    Logger log = org.slf4j.LoggerFactory.getLogger(DoSomeThingHandler.class);

    default void doSomeThing() {
        String cm = "doSomeThing@DoSomeThingHandler";
        log.warn("{} not implement", cm);
    }


    default List<String> getSomeThing() {
        String cm = "getSomeThing@DoSomeThingHandler";
        log.warn("{} not implement", cm);
        return Collections.EMPTY_LIST;
    }
}
