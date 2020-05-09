package monkey.common;

import java.util.UUID;

/**
 * FileName: Token
 * Description:
 * Author: ChenQ
 * Date:  2020/4/28
 */
public class Token {

    public static String create(Long id, Long time) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().replace("-", "").toUpperCase();
        s = s.substring(0, 12) + id + s.substring(12) + time;
        return Md5Helper.encode(s);
    }
}
