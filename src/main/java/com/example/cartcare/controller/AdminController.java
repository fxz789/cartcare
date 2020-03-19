package com.example.cartcare.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.cartcare.model.*;
import com.example.cartcare.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 跳转后台登录页面
     */
    @RequestMapping("Admin/login")
    public String login (){
        return "admin/login";
    }

    /**
     * 管理员登录
     */
    @ResponseBody
    @RequestMapping(value = "Admin/alogin",method = RequestMethod.POST)
    public JSONObject alogin(@RequestBody String request, HttpSession session){
        JSONObject jsonObject = JSONObject.parseObject(request);
        Map<String,Object> map = (Map<String,Object>)jsonObject;

        String username = String.valueOf(map.get("userName"));
        String password = String.valueOf(map.get("nuse"));
        System.out.println(username+" - "+password);

        if (username.equals("admin888")&&password.equals("12345678")){//超级管理员
            session.setAttribute("su","admin888");
            //session.removeAttribute("role");
            jsonObject.put("msg", "super");
        }else if(!username.equals("admin")){//普通管理员
            Admin a = new Admin();
            a = adminService.Login(username,password);
            if (a != null){
                session.setAttribute("admin","admin");
                session.setAttribute("role",a);
                jsonObject.put("msg", "root");
            }else{
                jsonObject.put("msg", "error");
            }
        }
        else{
            jsonObject.put("msg", "error");
        }
        return jsonObject;
    }

    /**
     * 退出登录 - loginout
     */
    @RequestMapping("Admin/loginout")
    public String loginout(HttpSession session){
        session.removeAttribute("su");
        session.removeAttribute("admin");
        session.removeAttribute("role");
        return "redirect:/Admin/login";
    }

    /**
     * 进入系统首页 - 超级管理员
     */
    @RequestMapping("Admin/system")
    public String system(HttpSession session){
        String su = (String) session.getAttribute("su");
        if (su!=null){
            if (su.equals("admin888")){
                return "admin/system";
            }else {
                return "redirect:/Admin/login";
            }
        }else {
            return "redirect:/Admin/login";
        }
    }

    /**
     * 进入系统首页 - 普通管理员
     */
    @RequestMapping("Admin/index")
    public String index(HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        if (admin!=null){
            if (admin.equals("admin")){
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                return "admin/index";
            }else {
                return "redirect:/Admin/login";
            }
        }else {
            return "redirect:/Admin/login";
        }
    }

    /**
     * 管理员
     */
    @RequestMapping("Admin/admin")
    public String admin(HttpServletRequest request,HttpSession session,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,Model model){
        String su = (String) session.getAttribute("su");
        String search = request.getParameter("search");
        if (su!=null){
            if (su.equals("admin888")){
                PageHelper.startPage(pageNo,pageSize);
                PageInfo<Admin> pageInfo = new PageInfo<>(adminService.getAdmins(search));
                System.out.println(pageInfo);
                model.addAttribute(pageInfo);
                return "admin/admin";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 删除管理员方法
     */
    @RequestMapping("Admin/adminDelete")
    public String adminDelete(HttpServletRequest request,HttpSession session){
        String su = (String) session.getAttribute("su");
        int id = Integer.parseInt(request.getParameter("id"));
        if (su!=null&&id>0){
            if (su.equals("admin888")){
                int status = adminService.adminDelete(id);
                return "redirect:/Admin/admin";
            }else {
                return "redirect:/Admin/login";
            }
        }else {
            return "redirect:/Admin/login";
        }
    }

    /**
     * 添加管理员
     */@RequestMapping("Admin/adminAdd")
    public String adminAdd(HttpServletRequest request,HttpSession session){
        String su = (String) session.getAttribute("su");
        if (su!=null){
            if (su.equals("admin888")){
                return "admin/admin_add";
            }else {
                return "redirect:/Admin/login";
            }
        }else {
            return "redirect:/Admin/login";
        }
    }

    /**
     * 添加管理员方法
     */
    @RequestMapping("Admin/adminAddAction")
    public String adminAddAction(HttpServletRequest request,HttpSession session,Model model){
        String su = (String) session.getAttribute("su");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String dept = request.getParameter("dept");
        if (su!=null){
            if (su.equals("admin888")){
                Admin a = new Admin();
                a.setUsername(username);
                a.setPassword(password);
                a.setDept(dept);
                System.out.println(adminService.adminAddAction(a));
                return "redirect:/Admin/admin";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 管理员修改
     */
    @RequestMapping("Admin/adminUpdate")
    public String adminUpdate(HttpServletRequest request,HttpSession session,Model model){
        String su = (String) session.getAttribute("su");
        int id = Integer.parseInt(request.getParameter("id"));
        if (su!=null){
            if (su.equals("admin888")){
                Admin a = new Admin();
                a = adminService.getAdminById(id);
                model.addAttribute("admin",a);
                return "admin/admin_update";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 管理员修改方法
     */
    @RequestMapping("Admin/adminUpdateAction")
    public String adminUpdateAction(HttpServletRequest request,HttpSession session,Model model){
        String su = (String) session.getAttribute("su");
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String dept = request.getParameter("dept");
        if (su!=null){
            if (su.equals("admin888")){
                Admin a = new Admin();
                a.setId(id);
                a.setDept(dept);
                a.setUsername(username);
                a.setPassword(password);
                System.out.println(adminService.adminUpdateAction(a));
                return "redirect:/Admin/admin";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 会员管理
     */
    @RequestMapping("Admin/user")
    public String user(HttpServletRequest request,HttpSession session,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,Model model){
        String admin = (String) session.getAttribute("admin");
        String search = request.getParameter("search");
        if (admin!=null){
            if (admin.equals("admin")){
                PageHelper.startPage(pageNo,pageSize);
                PageInfo<User> pageInfo = new PageInfo<>(adminService.getUsers(search));
                System.out.println(pageInfo);
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                model.addAttribute(pageInfo);
                return "admin/user";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 添加会员
     */@RequestMapping("Admin/userAdd")
    public String userAdd(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        if (admin!=null){
            if (admin.equals("admin")){
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                return "admin/user_add";
            }else {
                return "redirect:/Admin/login";
            }
        }else {
            return "redirect:/Admin/login";
        }
    }

    /**
     * 添加会员方法
     */
    @RequestMapping("Admin/userAddAction")
    public String userAddAction(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        String truename = request.getParameter("truename");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String beizhu = request.getParameter("beizhu");
        if (admin!=null){
            if (admin.equals("admin")){
                User u = new User();
                u.setTruename(truename);
                u.setPhone(phone);
                u.setPassword(password);
                u.setBeizhu(beizhu);
                u.setStatus(1);
                System.out.println(adminService.userAddAction(u));
                return "redirect:/Admin/user";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 会员修改
     */
    @RequestMapping("Admin/userUpdate")
    public String userUpdate(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("id"));
        if (admin!=null){
            if (admin.equals("admin")){
                User u = new User();
                u = adminService.getUserById(id);
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                model.addAttribute("user",u);
                return "admin/user_update";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 会员修改方法
     */
    @RequestMapping("Admin/userUpdateAction")
    public String userUpdateAction(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("id"));
        String truename = request.getParameter("truename");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String beizhu = request.getParameter("beizhu");
        if (admin!=null){
            if (admin.equals("admin")){
                User u = new User();
                u.setId(id);
                u.setBeizhu(beizhu);
                u.setTruename(truename);
                u.setPassword(password);
                u.setPhone(phone);
                System.out.println(adminService.userUpdateAction(u));
                return "redirect:/Admin/user";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 会员封号
     */
    @RequestMapping("Admin/userTingyong")
    public String userTingyong(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("id"));
        if (admin!=null){
            if (admin.equals("admin")){
                System.out.println(adminService.userTingyong(id));
                return "redirect:/Admin/user";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 会员解封
     */
    @RequestMapping("Admin/userQiyong")
    public String userQiyong(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("id"));
        if (admin!=null){
            if (admin.equals("admin")){
                System.out.println(adminService.userQiyong(id));
                return "redirect:/Admin/user";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 车辆管理
     */
    @RequestMapping("Admin/cart")
    public String cart(HttpServletRequest request,HttpSession session,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,Model model){
        String admin = (String) session.getAttribute("admin");
        String search = request.getParameter("search");
        if (admin!=null){
            if (admin.equals("admin")){
                PageHelper.startPage(pageNo,pageSize);
                PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(adminService.getCarts(search));
                System.out.println(pageInfo);
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                model.addAttribute(pageInfo);
                return "admin/cart";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 会员添加车辆信息
     */
    @RequestMapping("Admin/userAddCart")
    public String userAddCart(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("id"));
        if (admin!=null){
            if (admin.equals("admin")){
                User user = adminService.getUserById(id);
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                model.addAttribute("user",user);
                return "admin/user_add_cart";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 上传图片
     */
    @ResponseBody
    @RequestMapping("Admin/upImgAction")
    public JSONObject catalogPicAction(HttpServletRequest request, HttpSession session, Model model, @RequestParam(name = "picture") MultipartFile pic) {
        JSONObject jsonResult = JSONObject.parseObject("{'token':'zhiquan'}");
        if (pic != null) {
            try {
                String uuidStr = UUID.randomUUID().toString();
                String uuid = uuidStr.substring(0, 8) + uuidStr.substring(9, 13) + uuidStr.substring(14, 18) + uuidStr.substring(19, 23) + uuidStr.substring(24);
                //从文件名称的后缀名.结束（如：hello.pdf=>把hello去掉,留下.pdf）
                String OldFileName = pic.getOriginalFilename();//原来文件名
                int beginIndex = OldFileName.lastIndexOf(".");
                String NewFileName = uuid + OldFileName.substring(beginIndex);//新文件名

                File path = new File(ResourceUtils.getURL("classpath:static").getPath().replace("%20", " ").replace('/', '\\'));
                path = new File("");
                String destFileName = "E:\\uploadCartCare" + File.separator + NewFileName;//上传后的文件名

                System.out.println(destFileName);
                File destFile = new File(destFileName);
                destFile.getParentFile().mkdirs();
                pic.transferTo(destFile);

                //System.out.println(NewFileName);
                jsonResult.put("url", NewFileName);
                jsonResult.put("status", "1");

            } catch (FileNotFoundException e) {
                jsonResult.put("status", "0");
            } catch (IOException e) {
                jsonResult.put("status", "0");
            }
        }
        return jsonResult;
    }

    /**
     * 会员添加车辆信息方法
     */
    @RequestMapping("Admin/userAddCartAction")
    public String userAddCartAction(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int userid = Integer.parseInt(request.getParameter("userid"));
        String vin = request.getParameter("vin");
        String chepaihao = request.getParameter("chepaihao");
        String chexing = request.getParameter("chexing");
        String color = request.getParameter("color");
        String pic = request.getParameter("pic");
        String pinpai = request.getParameter("pinpai");
        if (admin!=null){
            if (admin.equals("admin")){
                Cart c = new Cart();
                c.setUserid(userid);
                c.setVin(vin);
                c.setChepaihao(chepaihao);
                c.setChexing(chexing);
                c.setColor(color);
                c.setPic(pic);
                c.setPinpai(pinpai);
                System.out.println(adminService.userAddCartAction(c));
                return "redirect:/Admin/cart";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 会员修改车辆信息
     */
    @RequestMapping("Admin/userUpdateCart")
    public String userUpdateCart(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("id"));
        if (admin!=null){
            if (admin.equals("admin")){
                Cart cart = adminService.getCartById(id);
                User user = adminService.getUserById(cart.getUserid());
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                model.addAttribute("cart",cart);
                model.addAttribute("user",user);
                return "admin/user_update_cart";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 删除车辆信息
     */
    @RequestMapping("Admin/cartDelete")
    public String cartDelete(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("id"));
        if (admin!=null){
            if (admin.equals("admin")){
                System.out.println(adminService.cartDelete(id));
                return "redirect:/Admin/cart";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 会员修改车辆信息方法
     */
    @RequestMapping("Admin/userUpdateCartAction")
    public String userUpdateCartAction(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("id"));
        String chexing = request.getParameter("chexing");
        String color = request.getParameter("color");
        String pic = request.getParameter("pic");
        int userid = Integer.parseInt(request.getParameter("userid"));
        String vin = request.getParameter("vin");
        String chepaihao = request.getParameter("chepaihao");
        String pinpai = request.getParameter("pinpai");
        if (admin!=null){
            if (admin.equals("admin")){
                Cart c = new Cart();
                c.setId(id);
                c.setUserid(userid);
                c.setVin(vin);
                c.setChepaihao(chepaihao);
                c.setChexing(chexing);
                c.setColor(color);
                c.setPic(pic);
                c.setPinpai(pinpai);
                System.out.println(adminService.userUpdateCartAction(c));
                return "redirect:/Admin/cart";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 新闻资讯
     */
    @RequestMapping("Admin/article")
    public String article(HttpSession session,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,Model model){
        String admin = (String) session.getAttribute("admin");
        if (admin!=null){
            if (admin.equals("admin")){
                PageHelper.startPage(pageNo,pageSize);
                PageInfo<Article> pageInfo = new PageInfo<>(adminService.getArticle());
                System.out.println(pageInfo);
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                model.addAttribute(pageInfo);
                return "admin/article";
            }else {
                return "redirect:/Admin/login";
            }
        }else {
            return "redirect:/Admin/login";
        }
    }

    /**
     * 添加新闻资讯
     */
    @RequestMapping("Admin/articleAdd")
    public String articleAdd(HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        if (admin!=null){
            if (admin.equals("admin")){
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                return "admin/article_add";
            }else {
                return "redirect:/Admin/login";
            }
        }else {
            return "redirect:/Admin/login";
        }
    }

    /**
     * 添加新闻资讯方法
     */@RequestMapping("Admin/articleAddAction")
    public String articleAddAction(HttpServletRequest request,HttpSession session){
        String admin = (String) session.getAttribute("admin");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Timestamp ts=new Timestamp(new Date().getTime());
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setCreateat(ts);
        System.out.println(article);
        if (admin!=null){
            if (admin.equals("admin")){
                int status = adminService.articleAddAction(article);
                return "redirect:/Admin/article";
            }else {
                return "redirect:/Admin/login";
            }
        }else {
            return "redirect:/Admin/login";
        }
    }

    /**
     * 删除新闻资讯方法
     */
    @RequestMapping("Admin/articleDelete")
    public String articleDelete(HttpServletRequest request,HttpSession session){
        String admin = (String) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("id"));
        if (admin!=null&&id>0){
            if (admin.equals("admin")){
                int status = adminService.articleDelete(id);
                return "redirect:/Admin/article";
            }else {
                return "redirect:/Admin/login";
            }
        }else {
            return "redirect:/Admin/login";
        }
    }

    /**
     * 维修记录
     */
    @RequestMapping("Admin/marks")
    public String marks(HttpServletRequest request,HttpSession session,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,Model model){
        String admin = (String) session.getAttribute("admin");
        String search = request.getParameter("search");
        if (admin!=null){
            if (admin.equals("admin")){
                PageHelper.startPage(pageNo,pageSize);
                PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(adminService.getMarks(search));
                System.out.println(pageInfo);
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                model.addAttribute(pageInfo);
                return "admin/marks";
            }else {
                return "redirect:/Admin/login";
            }
        }else {
            return "redirect:/Admin/login";
        }
    }

    /**
     * 添加维修记录
     */
    @RequestMapping("Admin/addMarks")
    public String addMarks(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("id"));
        if (admin!=null){
            if (admin.equals("admin")){
                model.addAttribute("id",id);
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                return "admin/marks_add";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 添加维修记录方法
     */
    @RequestMapping("Admin/addMarksAction")
    public String addMarksAction(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("userid"));
        String vin = request.getParameter("vin");
        String chepaihao = request.getParameter("chepaihao");
        int price = Integer.parseInt(request.getParameter("price"));
        String title = request.getParameter("title");
        Timestamp ts = new Timestamp(new Date().getTime());
        if (admin!=null){
            if (admin.equals("admin")){
                Marks marks = new Marks();
                marks.setUserid(id);
                marks.setTitle(title);
                marks.setCreateat(ts);
                marks.setChepaihao(chepaihao);
                marks.setPrice(price);
                marks.setVin(vin);
                System.out.println(marks);
                System.out.println(adminService.addMarksAction(marks));
                return "redirect:/Admin/marks";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 留言管理
     */
    @RequestMapping("Admin/liuyan")
    public String liuyan(HttpServletRequest request,HttpSession session,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,Model model){
        String admin = (String) session.getAttribute("admin");
        String search = request.getParameter("search");
        if (admin!=null){
            if (admin.equals("admin")){
                PageHelper.startPage(pageNo,pageSize);
                PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(adminService.getLiuyans(search));
                System.out.println(pageInfo);
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                model.addAttribute(pageInfo);
                return "admin/liuyan";
            }else {
                return "redirect:/Admin/login";
            }
        }else {
            return "redirect:/Admin/login";
        }
    }

    /**
     * 查看留言
     */
    @RequestMapping("Admin/ChakanLiuyan")
    public String ChakanLiuyan(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("id"));
        if (admin!=null){
            if (admin.equals("admin")){
                Liuyan liuyan = adminService.ChakanLiuyan(id);
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                model.addAttribute(liuyan);
                return "admin/liuyan_detail";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 回复管理
     */
    @RequestMapping("Admin/huifu")
    public String huifu(HttpServletRequest request,HttpSession session,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,Model model){
        String admin = (String) session.getAttribute("admin");
        String search = request.getParameter("search");
        if (admin!=null){
            if (admin.equals("admin")){
                PageHelper.startPage(pageNo,pageSize);
                PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(adminService.getHuifus(search));
                System.out.println(pageInfo);
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                model.addAttribute(pageInfo);
                return "admin/huifu";
            }else {
                return "redirect:/Admin/login";
            }
        }else {
            return "redirect:/Admin/login";
        }
    }

    /**
     * 回复留言
     */
    @RequestMapping("Admin/huifuAction")
    public String huifuAction(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int liuyanid = Integer.parseInt(request.getParameter("liuyanid"));
        int userid = Integer.parseInt(request.getParameter("userid"));
        String totitle = request.getParameter("totitle");
        String content = request.getParameter("content");
        Timestamp ts = new Timestamp(new Date().getTime());
        if (admin!=null){
            if (admin.equals("admin")){
                Huifu huifu = new Huifu();
                huifu.setContent(content);
                huifu.setCreateat(ts);
                huifu.setLiuyanid(liuyanid);
                huifu.setStatus(1);
                huifu.setUserid(userid);
                huifu.setTotitle(totitle);
                System.out.println(adminService.huifuAction(huifu));
                System.out.println(adminService.UpdateLiuyanStatus(liuyanid));
                return "redirect:/Admin/huifu";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }

    /**
     * 查看回复
     */
    @RequestMapping("Admin/ChakanHuifu")
    public String ChakanHuifu(HttpServletRequest request,HttpSession session,Model model){
        String admin = (String) session.getAttribute("admin");
        int id = Integer.parseInt(request.getParameter("id"));
        if (admin!=null){
            if (admin.equals("admin")){
                Huifu huifu = adminService.ChakanHuifu(id);
                List<Liuyan> liuyanList = adminService.getLiuyansByStatus();
                model.addAttribute(liuyanList);
                model.addAttribute(huifu);
                return "admin/huifu_detail";
            }
            else {
                return "redirect:/Admin/login";
            }
        }else{
            return "redirect:/Admin/login";
        }
    }
}
