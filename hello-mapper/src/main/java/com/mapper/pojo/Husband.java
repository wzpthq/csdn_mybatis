package com.mapper.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangzhiping on 17/3/15.
 */
public class Husband implements Serializable {

    private int id;

    private String name;

    private int wife_id;

    private Date createdAt;

    private Date updatedAt;

    private Wife wife;

    public int getWife_id() {
        return wife_id;
    }

    public void setWife_id(int wife_id) {
        this.wife_id = wife_id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wife_id=" + wife_id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", wife=" + wife +
                '}';
    }
}
