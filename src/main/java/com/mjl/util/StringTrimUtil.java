package com.mjl.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * @author mjl
 * @date 2025/7/25.
 */
public class StringTrimUtil {
    private static final Logger log = LoggerFactory.getLogger(StringTrimUtil.class);

    public static void handleString(Object obj) {
        if (obj == null) {
            return;
        }
        Class<?> clazz = obj.getClass();

        // 处理对象的字段
        try {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value == null) {
                    continue;
                }
                // 处理String类型字段
                if (value instanceof String) {
                    String trimmed = ((String) value).trim();
                    field.set(obj, trimmed);
                }
            }
        } catch (IllegalAccessException e) {
            log.error("处理字段出现异常", e);
        }
    }
}
