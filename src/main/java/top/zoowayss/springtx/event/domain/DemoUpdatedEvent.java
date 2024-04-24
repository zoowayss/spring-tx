package top.zoowayss.springtx.event.domain;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/4/19 16:23
 */

public class DemoUpdatedEvent extends ApplicationEvent {

    private String userId;
    public DemoUpdatedEvent(Object source, String userId) {
        super(source);
        this.userId = userId;
    }

}
