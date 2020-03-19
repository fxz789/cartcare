package com.example.cartcare.model;

import java.sql.Timestamp;

public class Liuyan {
    private int id;
    private int userid;
    private String title;
    private String content;
    private Timestamp createat;
    private int status;

    @Override
    public String toString() {
        return "Liuyan{" +
                "id=" + id +
                ", userid=" + userid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createat=" + createat +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateat() {
        return createat;
    }

    public void setCreateat(Timestamp createat) {
        this.createat = createat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
