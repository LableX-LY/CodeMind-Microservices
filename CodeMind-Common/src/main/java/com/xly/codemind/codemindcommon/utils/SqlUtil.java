package com.xly.codemind.codemindcommon.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author X-LY。
 * @version 1.0
 * @createtime 2024/12/5 22:03
 * @description
 **/

public class SqlUtil {

    /**
     * 校验排序字段是否合法（防止 SQL 注入）
     * @param sortField 需要检验的子段
     * @return 是否合法
     */
    public static boolean validSortField(String sortField) {
        if (StringUtils.isBlank(sortField)) {
            return false;
        }
        return !StringUtils.containsAny(sortField, "=", "(", ")", " ");
    }
}
