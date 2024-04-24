package top.zoowayss.springtx;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Executor;

@EnableAsync
@MapperScan("top.zoowayss.springtx.mapper.**")
@EnableTransactionManagement
@SpringBootApplication
@EnableScheduling
public class SpringTXLauncher implements AsyncConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringTXLauncher.class, args);
    }


    /**
     * 配置 Springboot Async 注解所用的线程池
     *
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(20);
        taskExecutor.setThreadNamePrefix("async-task-");
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncUncaughtExceptionHandler();
    }

    static class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {

        Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
            log.error("Exception message - {} \nMethod name - {} \n Parameter value - {}", throwable.getMessage(), method.getName(), Arrays.stream(obj));
        }
    }
}
