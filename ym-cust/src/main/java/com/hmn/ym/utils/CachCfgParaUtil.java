package com.hmn.ym.utils;

import java.util.HashMap;
import java.util.Map;

public class CachCfgParaUtil {
    private static Map<String, String> cacheMap;

    public static String getCfgCache(String key) {
        String value = "";
        if (getCacheMap().containsKey(key)) {
            value = getCacheMap().get(key);
        }
        return value;
    }

    public static void putCfgCache(String key, String value) {
        getCacheMap().put(key, value);
    }

    public static Map<String, String> getCacheMap() {
        if (cacheMap == null) {
            cacheMap = new HashMap<String, String>();
        }
        return cacheMap;
    }
}
