package top.zoowayss.springtx.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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


    public static void main(String[] args) {
        String s = "https://t.me/share/url?text=%s&url=https://t.me/Unveil_AI_BOT?start=1";

        String template = "\uD83D\uDD25\uD83D\uDC59لقد وجدت بوت لإزالة الملابس بنقرة واحدة، وهو الأكثر واقعية وطبيعية، وهو الآن مجاني للاستخدام. أسرع وانضم! \uD83C\uDFC3\u200D♂\uFE0F\uD83D\uDCA8";

        try {
            String format = String.format(s, URLEncoder.encode(template, "UTF-8"));

            System.out.println(format);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
