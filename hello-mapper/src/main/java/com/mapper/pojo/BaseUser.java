package com.mapper.pojo;

/**
 * Created by wangzhiping on 17/3/14.
 */
public class BaseUser {

    private int id;

    private String name;

    public BaseUser() {
    }

    public BaseUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
