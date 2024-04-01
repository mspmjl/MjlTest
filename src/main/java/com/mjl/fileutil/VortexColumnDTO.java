package com.mjl.fileutil;

/**
 * @author MJL
 * @date 2024/3/29.
 */
public class VortexColumnDTO {
    private String name;
    private String type;
    private String comment;
    private Integer length = 50;
    private Boolean notNull = Boolean.FALSE;

    public Boolean getNotNull() {
        return notNull;
    }

    public void setNotNull(Boolean notNull) {
        this.notNull = notNull;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }


    public VortexColumnDTO(String name, String type, String comment, Integer length, Boolean notNull) {
        this.name = name;
        this.type = type;
        this.comment = comment;
        if (length != null) {
            this.length = length;
        }
        if (notNull != null) {
            this.notNull = notNull;
        }
    }
}
