package com.example.cartcare.model;

import java.sql.Timestamp;

public class Marks {
    private int id;
    private int price;
    private int userid;
    private String vin;
    private String chepaihao;
    private String title;
    private Timestamp createat;

    @Override
    public String toString() {
        return "Marks{" +
                "id=" + id +
                ", price=" + price +
                ", userid=" + userid +
                ", vin='" + vin + '\'' +
                ", chepaihao='" + chepaihao + '\'' +
                ", title='" + title + '\'' +
                ", createat=" + createat +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getChepaihao() {
        return chepaihao;
    }

    public void setChepaihao(String chepaihao) {
        this.chepaihao = chepaihao;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreateat() {
        return createat;
    }

    public void setCreateat(Timestamp createat) {
        this.createat = createat;
    }
}
