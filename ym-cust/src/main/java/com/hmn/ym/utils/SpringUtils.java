package com.hmn.ym.utils;

import com.alibaba.fastjson.JSONObject;
import com.hmn.ym.utils.result.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * json 格式输入 公用
 *
 * @author
 */
public class SpringUtils {

    private static final String ENCODING_PREFIX = "encoding";
    private static final String NOCACHE_PREFIX = "no-cache";
    private static final String ENCODING_DEFAULT = "UTF-8";
    private static final boolean NOCACHE_DEFAULT = true;
    private static Logger logger = LoggerFactory.getLogger(SpringUtils.class);

    public static void renderJsonResult(HttpServletResponse response,
                                        String code, String message) {
        JsonResult rest = new JsonResult(code, message);

        SpringUtils.renderJson(response, rest);
    }


    /**
     * 直接输出JSON. Java对象,将被转化为json字符串.
     */
    public static void renderJson(HttpServletResponse response,
                                  final Object object, final String... headers) {
        String jsonString = fromObject(object);
        renderJson(response, jsonString, headers);
    }

    /**
     * 直接输出JSON格式
     *
     * @param string json字符串.
     */
    public static void renderJson(HttpServletResponse response,
                                  final String string, final String... headers) {
        render(response, "application/json", string, headers);
    }

    /**
     * 直接输出内容的简便函数.
     */
    public static void render(HttpServletResponse response,
                              final String contentType, final String content,
                              final String... headers) {
        try {
            // 分析headers参数
            String encoding = ENCODING_DEFAULT;
            boolean noCache = NOCACHE_DEFAULT;
            for (String header : headers) {
                String headerName = StringUtils.substringBefore(header, ":");
                String headerValue = StringUtils.substringAfter(header, ":");

                if (StringUtils.equalsIgnoreCase(headerName, ENCODING_PREFIX)) {
                    encoding = headerValue;
                } else if (StringUtils.equalsIgnoreCase(headerName,
                        NOCACHE_PREFIX)) {
                    noCache = Boolean.parseBoolean(headerValue);
                } else
                    throw new IllegalArgumentException(headerName
                            + "不是一个合法的header类型");
            }
            // 设置headers参数
            String fullContentType = contentType + ";charset=" + encoding;
            response.setContentType(fullContentType);
            if (noCache) {
                response.setHeader("Pragma", "No-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.setDateHeader("Expires", 0);
            }

            response.getWriter().write(content);
            response.getWriter().flush();

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 对象转换json格式字符串
     *
     * @param obj
     * @return
     */
    public static String fromObject(Object obj) {
        return JSONObject.toJSONString(obj);
    }
}
