package com.example.cartcare.service;

import com.example.cartcare.mapper.AdminMapper;
import com.example.cartcare.model.*;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminService {
    @Autowired
    public AdminMapper adminMapper;

    public Admin Login(String username, String password) {return adminMapper.Login(username,password);}

    public Page<Admin> getAdmins(String search) {return adminMapper.getAdmins(search);}

    public int adminDelete(int id) {return adminMapper.adminDelete(id);}

    public boolean adminAddAction(Admin a) {return adminMapper.adminAddAction(a);}

    public Admin getAdminById(int id) {return adminMapper.getAdminById(id);}

    public boolean adminUpdateAction(Admin a) {return adminMapper.adminUpdateAction(a);}

    public Page<User> getUsers(String search) {return adminMapper.getUsers(search);}

    public boolean userAddAction(User u) {return adminMapper.userAddAction(u);}

    public User getUserById(int id) {return adminMapper.getUserById(id);}

    public boolean userUpdateAction(User u) {return adminMapper.userUpdateAction(u);}

    public boolean userTingyong(int id) {return adminMapper.userTingyong(id);}

    public boolean userQiyong(int id) {return adminMapper.userQiyong(id);}

    public List<Map<String, Object>> getCarts(String search) {return adminMapper.getCarts(search);}

    public boolean userAddCartAction(Cart c) {return adminMapper.userAddCartAction(c);}

    public Cart getCartById(int id) {return adminMapper.getCartById(id);}

    public boolean cartDelete(int id) {return adminMapper.cartDelete(id);}

    public boolean userUpdateCartAction(Cart c) {return adminMapper.userUpdateCartAction(c);}

    public Page<Article> getArticle() {return adminMapper.getArticle();}

    public int articleAddAction(Article article) {
        try {
            adminMapper.articleAddAction(article);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    public int articleDelete(int id) {return adminMapper.articleDelete(id);}

    public List<Map<String, Object>> getMarks(String search) {return adminMapper.getMarks(search);}

    public boolean addMarksAction(Marks marks) {return adminMapper.addMarksAction(marks);}

    public List<Map<String, Object>> getLiuyans(String search) {return adminMapper.getLiuyans(search);}

    public Liuyan ChakanLiuyan(int id) {return adminMapper.ChakanLiuyan(id);}

    public List<Map<String, Object>> getHuifus(String search) {return adminMapper.getHuifus(search);}

    public boolean huifuAction(Huifu huifu) {return adminMapper.huifuAction(huifu);}

    public boolean UpdateLiuyanStatus(int liuyanid) {return adminMapper.UpdateLiuyanStatus(liuyanid);}

    public Huifu ChakanHuifu(int id) {return adminMapper.ChakanHuifu(id);}

    public List<Liuyan> getLiuyansByStatus() {return adminMapper.getLiuyansByStatus();}
}
