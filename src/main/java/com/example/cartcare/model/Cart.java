package com.example.cartcare.model;

public class Cart {
    private int id;
    private int userid;
    private String vin;
    private String color;
    private String chepaihao;
    private String chexing;
    private String pinpai;
    private String pic;

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userid=" + userid +
                ", vin='" + vin + '\'' +
                ", color='" + color + '\'' +
                ", chepaihao='" + chepaihao + '\'' +
                ", chexing='" + chexing + '\'' +
                ", pinpai='" + pinpai + '\'' +
                ", pic='" + pic + '\'' +
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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getChepaihao() {
        return chepaihao;
    }

    public void setChepaihao(String chepaihao) {
        this.chepaihao = chepaihao;
    }

    public String getChexing() {
        return chexing;
    }

    public void setChexing(String chexing) {
        this.chexing = chexing;
    }

    public String getPinpai() {
        return pinpai;
    }

    public void setPinpai(String pinpai) {
        this.pinpai = pinpai;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
