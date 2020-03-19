package com.example.cartcare.model;

public class User {
    private int id;
    private String truename;
    private String phone;
    private String password;
    private String beizhu;
    private int status;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", truename='" + truename + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", beizhu='" + beizhu + '\'' +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
