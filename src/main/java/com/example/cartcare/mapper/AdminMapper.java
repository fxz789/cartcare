package com.example.cartcare.mapper;

import com.example.cartcare.model.*;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminMapper {
    @Select("Select * from Admin WHERE username = #{username} and password = #{password}")
    Admin Login(String username, String password);

    @Select("select * from Admin where " +
            "if(#{search} !='',username=#{search},1=1) " +
            " order by id DESC")
    Page<Admin> getAdmins( String search);

    @Delete("delete from Admin where id = #{id}")
    int adminDelete(int id);

    @Insert("INSERT INTO Admin(username,password,dept) " +
            "VALUES(#{username},#{password},#{dept})")
    boolean adminAddAction(Admin a);

    @Select("select * from Admin WHERE id = #{id}")
    Admin getAdminById(int id);

    @Update("UPDATE Admin SET username = #{username},password = #{password},dept = #{dept} WHERE id = #{id}")
    boolean adminUpdateAction(Admin a);

    @Select("select * from User where " +
            "if(#{search} !='',truename=#{search},1=1) " +
            " order by id DESC")
    Page<User> getUsers( String search);

    @Insert("INSERT INTO User(truename,phone,password,beizhu,status) " +
            "VALUES(#{truename},#{phone},#{password},#{beizhu},#{status})")
    boolean userAddAction(User u);

    @Select("select * from User WHERE id = #{id}")
    User getUserById(int id);

    @Update("UPDATE User SET truename = #{truename},password = #{password},phone = #{phone},beizhu = #{beizhu} WHERE id = #{id}")
    boolean userUpdateAction(User u);

    @Update("UPDATE User SET status = 0 WHERE id = #{id}")
    boolean userTingyong(int id);

    @Update("UPDATE User SET status = 1 WHERE id = #{id}")
    boolean userQiyong(int id);

    @Select("select " +
            "c.vin , c.color , c.chepaihao ,c.pinpai , c.chexing , c.pic , c.id as cid , c.userid , " +
            "u.truename " +
            "from Cart as c " +
            "inner join User as u " +
            "on u.id = c.userid " +
            "WHERE " +
            "if(#{search} !='',u.truename = #{search},1=1) " +
            "order by c.id DESC")
    List<Map<String, Object>> getCarts(String search);

    @Insert("INSERT INTO Cart(userid,vin,chepaihao,chexing,color,pic,pinpai) " +
            "VALUES(#{userid},#{vin},#{chepaihao},#{chexing},#{color},#{pic},#{pinpai})")
    boolean userAddCartAction(Cart c);

    @Select("select * from Cart WHERE id = #{id}")
    Cart getCartById(int id);

    @Delete("delete from Cart where id = #{id}")
    boolean cartDelete(int id);

    @Update("UPDATE Cart SET " +
            "userid = #{userid}," +
            "vin = #{vin}," +
            "color = #{color}," +
            "chepaihao = #{chepaihao}," +
            "chexing = #{chexing}," +
            "pic = #{pic}," +
            "pinpai = #{pinpai} " +
            "WHERE id = #{id}")
    boolean userUpdateCartAction(Cart c);

    @Select("select * from Article order by id DESC")
    Page<Article> getArticle();

    @Insert("INSERT INTO Article(title,content,createat) VALUES(#{title},#{content},#{createat})")
    void articleAddAction(Article article);

    @Delete("delete from Article where id = #{id}")
    int articleDelete(int id);

    @Select("select " +
            "m.createat , m.vin , m.id as mid , m.title , m.chepaihao , m.price , " +
            "u.truename " +
            "from Marks as m " +
            "inner join User as u " +
            "on u.id = m.userid " +
            "WHERE " +
            "if(#{search} !='',u.truename = #{search},1=1) " +
            //" and m.userid = #{userid} "+
            "order by m.createat DESC")
    List<Map<String, Object>> getMarks(String search);

    @Insert("INSERT INTO Marks(userid,price,vin,chepaihao,title,createat) VALUES(#{userid},#{price},#{vin},#{chepaihao},#{title},#{createat})")
    boolean addMarksAction(Marks marks);

    @Select("select " +
            "l.createat , l.title , l.id as lid , l.content , l.status , l.userid , " +
            "u.truename " +
            "from Liuyan as l " +
            "inner join User as u " +
            "on u.id = l.userid " +
            "WHERE " +
            "if(#{search} !='',u.truename = #{search},1=1) " +
            //" and m.userid = #{userid} "+
            "order by l.createat DESC")
    List<Map<String, Object>> getLiuyans(String search);

    @Select("select * from Liuyan WHERE id = #{id}")
    Liuyan ChakanLiuyan(int id);

    @Select("select " +
            "h.createat , h.totitle , h.id as hid , h.content , h.status , h.liuyanid , h.userid , " +
            "u.truename " +
            "from Huifu as h " +
            "inner join User as u " +
            "on u.id = h.userid " +
            "WHERE " +
            "if(#{search} !='',u.truename = #{search},1=1) " +
            //" and m.userid = #{userid} "+
            "order by h.createat DESC")
    List<Map<String, Object>> getHuifus(String search);

    @Insert("INSERT INTO Huifu(userid,liuyanid,totitle,content,status,createat) " +
            "VALUES(#{userid},#{liuyanid},#{totitle},#{content},#{status},#{createat})")
    boolean huifuAction(Huifu huifu);

    @Update("UPDATE Liuyan SET status = 0 WHERE id = #{liuyanid}")
    boolean UpdateLiuyanStatus(int liuyanid);

    @Select("select * from Huifu WHERE id = #{id}")
    Huifu ChakanHuifu(int id);

    @Select("select * from Liuyan WHERE status = 1")
    List<Liuyan> getLiuyansByStatus();
}
