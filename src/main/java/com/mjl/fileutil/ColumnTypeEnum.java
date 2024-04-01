package com.mjl.fileutil;

/**
 * @author MJL
 * @date 2024/3/29.
 */
public enum ColumnTypeEnum {
    String("String"),
    BigDecimal("BigDecimal"),
    Integer("Integer"),
    LocalDate("LocalDate"),
    Date("Date"),
    Long("Long"),
    Double("Double"),
    Boolean("Boolean")

    ;

    private final String key;

    public String getKey() {
        return key;
    }

    ColumnTypeEnum(String key) {
        this.key = key;
    }
}
