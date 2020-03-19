package com.example.cartcare.model;

import java.sql.Timestamp;

public class Huifu {
    private int id;
    private int userid;
    private int liuyanid;
    private String totitle;
    private String content;
    private Timestamp createat;
    private int status;

    @Override
    public String toString() {
        return "Huifu{" +
                "id=" + id +
                ", userid=" + userid +
                ", liuyanid=" + liuyanid +
                ", totitle='" + totitle + '\'' +
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

    public int getLiuyanid() {
        return liuyanid;
    }

    public void setLiuyanid(int liuyanid) {
        this.liuyanid = liuyanid;
    }

    public String getTotitle() {
        return totitle;
    }

    public void setTotitle(String totitle) {
        this.totitle = totitle;
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
