package top.zoowayss.springtx.event.domain;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/7/8 16:55
 */
public class Some1Event extends ApplicationEvent {

    public Some1Event(Object source) {
        super(source);
    }
}
