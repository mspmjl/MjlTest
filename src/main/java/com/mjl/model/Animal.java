package com.mjl.model;

import java.util.List;

/**
 * @author MJL
 * @date 2023/3/9.
 */
public class Animal {
    private String type;
    private String desc;
    private List<Person> peopleList;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public List<Person> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<Person> peopleList) {
        this.peopleList = peopleList;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
