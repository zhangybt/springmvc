package com.product.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 值校验工具类
 * 
 * version 2017-3-1 上午11:32:23
 * author sz
 */
public class ValueCheck {

    /**
     * 判断Object是否为空
     * 
     * param obj
     * return
     */
    public static final boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        }
        if (obj instanceof String) {
            return StringUtil.isEmpty((String) obj);
        }
        if (obj instanceof StringBuilder) {
            return obj.toString().trim().length() <= 0;
        }
        if (obj.getClass().isArray()) {
            return (null == (Object[])obj) || (((Object[])obj).length == 0);
        }
        if (obj instanceof Collection) {
            return (null == (Collection<?>) obj) || (((Collection<?>) obj).size() == 0);
        }
        if (obj instanceof Map) {
            return (null == (Map<?, ?>)obj) || (((Map<?, ?>)obj).size() == 0);
        }
        return false;
    }

    /**
     * 判断Object是否为非空
     * 
     * param obj
     * return
     */
    public static final boolean isNotEmpty(Object obj) {
        if (null == obj) {
            return false;
        }
        if (obj instanceof String) {
            return StringUtil.isNotEmpty((String) obj);
        }
        if (obj instanceof StringBuilder) {
            return obj.toString().trim().length() > 0;
        }
        if (obj instanceof StringBuffer) {
            return obj.toString().trim().length() > 0;
        }
        if (obj.getClass().isArray()) {
            return (null != (Object[])obj) && (((Object[])obj).length > 0);
        }
        if (obj instanceof Collection) {
            return (null != (Collection<?>) obj) && (((Collection<?>) obj).size() > 0);
        }
        if (obj instanceof Map) {
            return (null != (Map<?, ?>)obj) && (((Map<?, ?>)obj).size() > 0);
        }
        return true;
    }

    /**
     * 判断是否为真
     * 
     * param b
     * return
     */
    public static boolean isTrue(Boolean b) {
        return null == b ? false : b.booleanValue();
    }

    /**
     * 判断是否为数字或者字母
     * 
     * param s
     * return
     */
    public static boolean isNumberOrLetter(String s) {
        java.util.regex.Pattern patten = java.util.regex.Pattern.compile("[0-9A-Za-z]*");
        return patten.matcher(s).matches();
    }

    /**
     * 判断是否为数字
     * 
     * param s
     * return
     */
    public static boolean isNumber(String s) {
        java.util.regex.Pattern patten = java.util.regex.Pattern.compile("[0-9]*");
        return patten.matcher(s).matches();
    }
}
