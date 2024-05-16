package top.zoowayss.springtx.service;

/**
 * 懒得自己敲每个 currentMethod
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/5/16 09:31
 */
public interface LogService {
    default String cm() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // 堆栈的第一个元素是当前线程的 getStackTrace 方法，第二个元素是调用 getStackTrace 方法的方法，因此取第三个元素
        StackTraceElement stackTraceElement = stackTrace[2];
        return stackTraceElement.getMethodName() + "@" + this.getClass().getSimpleName();
    }
}
