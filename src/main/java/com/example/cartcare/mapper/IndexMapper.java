package com.example.cartcare.mapper;

import com.example.cartcare.model.*;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface IndexMapper {
    @Select("SELECT * FROM User WHERE truename = #{username} and password = #{password}")
    User loginAction(String username, String password);

    @Select("select " +
            "m.createat , m.vin , m.id as mid , m.title , m.chepaihao , m.price , " +
            "u.truename " +
            "from Marks as m " +
            "inner join User as u " +
            "on u.id = m.userid " +
            "WHERE " +
            "if(#{search} !='',m.chepaihao = #{search},1=1) " +
            " and m.userid = #{userid} "+
            "order by m.createat DESC")
    List<Map<String, Object>> myMakrs(int userid,String search);

    @Select("select " +
            "l.createat , l.title , l.id as lid , l.content , l.status , l.userid , " +
            "u.truename " +
            "from Liuyan as l " +
            "inner join User as u " +
            "on u.id = l.userid " +
            "WHERE " +
            " l.userid = #{userid} "+
            "order by l.createat DESC")
    List<Map<String, Object>> myComments(int id);

    @Select("select * from Liuyan WHERE id = #{id}")
    Liuyan ChakanLiuyan(int id);

    @Select("select * from Huifu WHERE liuyanid = #{id}")
    Huifu getHuifuById(int id);

    @Insert("INSERT INTO Liuyan(userid,title,content,createat,status) " +
            "VALUES(#{userid},#{title},#{content},#{createat},#{status})")
    boolean liuyanAction(Liuyan liuyan);
}
