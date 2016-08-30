package com.pro.test.core.util;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hxpeng on 2016/8/24.
 */
public class TokenUtils {

    /** token容器常量名*/
    private static final String TOKEN_CONTAINER = "_tokenContainer";

    /** token序列*/
    private static int tokenSeq = 100000;

    /**
     * 获取token
     *
     * @return 返回token
     */
    public static synchronized String generateToken() {
        tokenSeq = (++tokenSeq) > 100000000 ? 100000 : tokenSeq;
        return new Long(System.currentTimeMillis()).toString() + tokenSeq;
    }

    /**
     * 获取token容器
     *
     * @param session 当前会话
     *
     * @return 返回token容器
     */
    @SuppressWarnings("unchecked")
    private static Map<String, String> getTokenMap(HttpSession session) {
        Object obj = session.getAttribute(TOKEN_CONTAINER);

        if (obj != null) {
            return (Map<String, String>) obj;
        } else {
            Map<String, String> tokenMap = new HashMap<String, String>();

            session.setAttribute(TOKEN_CONTAINER, tokenMap);

            return tokenMap;
        }
    }

    /**
     * 创建token
     * @param session 当前会话
     *
     * @return 返回token
     */
    public static String createSessionToken(HttpSession session) {
        String token = generateToken();

        Map<String, String> tokenMap = getTokenMap(session);
        tokenMap.put(token, token);

        session.setAttribute(TOKEN_CONTAINER, tokenMap);

        return token;
    }

    /**
     * 验证token
     *
     * @param token token
     * @param session 当前会话
     *
     * @return 返回真假
     */
    public static boolean validSessionToken(String token, HttpSession session) {
        boolean valid = false;

        if (session != null) {
            Map<String, String> tokenMap = getTokenMap(session);

            if (tokenMap.containsKey(token)) {
                valid = true;
                tokenMap.remove(token);
            }
        }

        return valid;
    }
}
