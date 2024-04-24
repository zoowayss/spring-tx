package top.zoowayss.springtx.utils;

/**
 * @Author: <a href="https://github.com/zoowayss">zoowayss</a>
 * @Date: 2024/4/24 08:55
 */

public class UUIDUtils {

    public static String randomUUID() {
        return randomUUID(5);
    }

    public static String randomUUID(int len) {
        if (len < 1) len = 10;
        return java.util.UUID.randomUUID().toString().replace("-", "").substring(0, len);
    }


}
