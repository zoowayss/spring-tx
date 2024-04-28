package top.zoowayss.springtx.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import top.zoowayss.springtx.service.DoSomeThingHandler;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/4/19 18:12
 */
@Configuration
public class DefaultBeanAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestTemplate defaultRestTemplate() {
        return new RestTemplate();
    }


    @Bean
    @ConditionalOnMissingBean(DoSomeThingHandler.class)
    public DoSomeThingHandler defaultDoSomeThingHandler() {
        return new DoSomeThingHandler() {
        };
    }
}
