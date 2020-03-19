package com.example.cartcare.model;

import java.sql.Timestamp;

public class Article {
    private int id;
    private String title;
    private String content;
    private Timestamp createat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createat=" + createat +
                '}';
    }
}
