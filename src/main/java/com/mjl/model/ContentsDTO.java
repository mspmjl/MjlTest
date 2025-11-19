package com.mjl.model;

import java.util.List;

/**
 * @author mjl
 * @date 2025/9/26.
 */
public class ContentsDTO {
    private String name;
    private String title;
    private List<ContentsDTO> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ContentsDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ContentsDTO> children) {
        this.children = children;
    }
}
