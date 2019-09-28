package com.hmn.ym.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public final class InviteCodeGenerator {
    /**
     * 简单缓存去重
     */
    private static final Cache<Object, Object> cacheData = CacheBuilder.newBuilder().initialCapacity(100000).maximumSize(500000).build();
    /**
     * 计算器，初始值100，最大：999
     */
    private static AtomicInteger count = new AtomicInteger(100);

    /**
     * 生成用户邀请码
     *
     * @return
     */
    public static String inviteCode() {
        Integer num = count.incrementAndGet();
        if (num == 999) {
            count = new AtomicInteger(100);
        }
        String uuid = String.format("%s%d", getRandom(5), num);
        if (cacheData.asMap().get(uuid) != null) {
            inviteCode();
        } else {
            cacheData.asMap().put(uuid, uuid);
        }
        return uuid;
    }

    /**
     * 生成固定长度随机码
     *
     * @param length    长度
     *                      
     */
    private static long getRandom(int length) {
        long min = 1, max = 9;
        for (int i = 1; i < length; i++) {
            min *= 10;
            max *= 10;
        }
        return ThreadLocalRandom.current().nextLong(min, max);
    }
}
