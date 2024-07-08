package top.zoowayss.springtx.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import top.zoowayss.springtx.event.domain.Some1Event;

import static org.springframework.transaction.event.TransactionPhase.AFTER_ROLLBACK;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/7/8 16:55
 */
@Component
@Async
@Slf4j
public class Some1EventListener {


    @TransactionalEventListener
    public void onSome1Event(Some1Event event) {
        log.info("onSome1Event: {}", event);


    }

    @TransactionalEventListener(phase = AFTER_ROLLBACK)
    public void onSome1EventRollback(Some1Event event) {
        log.info("onSome1EventRollback: {}", event);
    }
}
