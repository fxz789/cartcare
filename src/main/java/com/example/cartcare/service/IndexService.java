package com.example.cartcare.service;

import com.example.cartcare.mapper.IndexMapper;
import com.example.cartcare.model.*;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class IndexService {
    @Autowired
    public IndexMapper indexMapper;

    public User loginAction(String username, String password) {
        return indexMapper.loginAction(username,password);
    }

    public List<Map<String, Object>> myMakrs(int id,String search) {return indexMapper.myMakrs(id,search);}

    public List<Map<String, Object>> myComments(int id) {return indexMapper.myComments(id);}

    public Liuyan ChakanLiuyan(int id) {return indexMapper.ChakanLiuyan(id);}

    public Huifu getHuifuById(int id) {return indexMapper.getHuifuById(id);}

    public boolean liuyanAction(Liuyan liuyan) {return indexMapper.liuyanAction(liuyan);}
}
