package com.hmn.ym.utils;

import com.hmn.ym.common.enums.ServerCode;
import com.hmn.ym.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

/**
 * 参数校验工具类
 *
 * @author xufz
 */
public final class Assert {

    /**
     * 判断包装数值类型是否不等于空并大于0，否则抛错
     *
     * @param obj
     * @param tips
     */
    public static void isGreaterThanZero(Object obj, String tips) {
        if (obj != null) {
            if ((obj instanceof Integer && ((Integer) obj) > 0) || (obj instanceof Long && ((Long) obj) > 0L) || (obj instanceof Double && ((Double) obj) > 0.0D)
                    || (obj instanceof Float && ((Float) obj) > 0.0F)) {
                return;
            }
        }
        throw new BizException(ServerCode.PARAM_ERROR.code(), tips);
    }

    /**
     * 判断包装数值类型是否不等于空并大于0，否则抛错
     *
     * @param obj
     * @param tips
     * @param errCode
     */
    public static void isGreaterThanZero(Object obj, String tips, int errCode) {
        if (obj != null) {
            if ((obj instanceof Integer && ((Integer) obj) > 0) || (obj instanceof Long && ((Long) obj) > 0L) || (obj instanceof BigDecimal && ((BigDecimal) obj).doubleValue() > 0D)
                    || (obj instanceof Float && ((Float) obj) > 0.0F) || (obj instanceof Double && ((Double) obj) > 0.0D)) {
                return;
            }
        }
        throw new BizException(errCode, tips);
    }

    /**
     * obj等于null时，抛错
     *
     * @param obj
     * @param tips
     * @throws BizException
     */
    public static void isNotNull(Object obj, String tips) {
        if (obj == null) {
            throw new BizException(ServerCode.PARAM_ERROR.code(), tips);
        }
    }

    /**
     * obj等于null时，抛错
     *
     * @param obj
     * @param tips
     * @param errCode 默认抛参数异常
     * @throws BizException
     */
    public static void isNotNull(Object obj, String tips, int errCode) {
        if (obj == null) {
            throw new BizException(errCode, tips);
        }
    }

    /**
     * bool不等于true时，抛错
     *
     * @param bool
     * @param tips
     * @throws BizException
     */
    public static void isTrue(boolean bool, String tips) {
        if (!bool) {
            throw new BizException(ServerCode.PARAM_ERROR.code(), tips);
        }
    }

    /**
     * bool不等于true时，抛错
     *
     * @param bool
     * @param tips
     * @param errCode 默认抛参数异常
     * @throws BizException
     */
    public static void isTrue(boolean bool, String tips, int errCode) {
        if (!bool) {
            throw new BizException(errCode, tips);
        }
    }

    /**
     * 字符串s为null或trim后为空串时，抛错
     *
     * @param s
     * @param tips
     * @throws BizException
     */
    public static void isNotBlank(String s, String tips) {
        if (StringUtils.isBlank(s)) {
            throw new BizException(ServerCode.PARAM_ERROR.code(), tips);
        }
    }

    /**
     * 字符串s为null或trim后为空串时，抛错
     *
     * @param s
     * @param tips
     * @param errCode 默认抛参数异常
     * @throws BizException
     */
    public static void isNotBlank(String s, String tips, int errCode) {
        if (s == null || s.trim().length() == 0) {
            throw new BizException(errCode, tips);
        }
    }

    /**
     * 数组为null或空时，抛错
     *
     * @param s
     * @param tips
     * @throws BizException
     */
    public static void isNotEmptyArrayOfInt(int[] arr, String tips) {
        if (arr == null || arr.length == 0) {
            throw new BizException(ServerCode.PARAM_ERROR.code(), tips);
        }
    }

    /**
     * 数组为null或空时，抛错
     *
     * @param s
     * @param tips
     * @param errCode 默认抛参数异常
     * @throws BizException
     */
    public static void isNotEmptyArrayOfInt(int[] arr, String tips, int errCode) {
        if (arr == null || arr.length == 0) {
            throw new BizException(errCode, tips);
        }
    }

    /**
     * 集合为null或空时，抛错
     *
     * @param s
     * @param tips
     * @throws BizException
     */
    public static void isNotEmptyCollection(Collection<?> c, String tips) {
        if (c == null || c.size() == 0) {
            throw new BizException(ServerCode.PARAM_ERROR.code(), tips);
        }
    }

    /**
     * 集合为null或空时，抛错
     *
     * @param s
     * @param tips
     * @param errCode 默认抛参数异常
     * @throws BizException
     */
    public static void isNotEmptyCollection(Collection<?> c, String tips, int errCode) {
        if (c == null || c.size() == 0) {
            throw new BizException(errCode, tips);
        }
    }

    /**
     * map为null或空时，抛错
     *
     * @param s
     * @param tips
     * @throws BizException
     */
    public static void isNotEmptyMap(Map<?, ?> c, String tips) {
        if (c == null || c.size() == 0) {
            throw new BizException(ServerCode.PARAM_ERROR.code(), tips);
        }
    }

    /**
     * map为null或空时，抛错
     *
     * @param s
     * @param tips
     * @param errCode 默认抛参数异常
     * @throws BizException
     */
    public static void isNotEmptyMap(Map<?, ?> c, String tips, int errCode) {
        if (c == null || c.size() == 0) {
            throw new BizException(errCode, tips);
        }
    }
}
