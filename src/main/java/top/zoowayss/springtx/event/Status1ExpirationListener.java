package top.zoowayss.springtx.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Status1ExpirationListener extends KeyExpirationEventMessageListener {

    public Status1ExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {

        log.info("message: {}, {}", new String(pattern),message);
        // message.toString()可以获取失效的key
        String expiredKey = message.toString();
        // 业务处理
        log.info("key: {} expired", expiredKey);
    }

}
