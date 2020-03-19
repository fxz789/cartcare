package com.example.cartcare.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.cartcare.model.*;
import com.example.cartcare.service.IndexService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


@Controller
@RequestMapping("/Home")
public class IndexController {
    @Autowired
    private IndexService indexService;

    /**
     * 前台首页
     */
    @RequestMapping("/index")
    public String index (Model model){
        return "home/index";
    }

    /**
     * vin码 搜索
     */
    @RequestMapping("/vin")
    public String vin(HttpServletRequest request,Model model) {
        String vin = request.getParameter("vin");
        if (!vin.equals(" ")){
            //1.生成httpclient，相当于该打开一个浏览器
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = null;
            //2.创建get请求，相当于在浏览器地址栏输入 网址
            HttpGet httpGet = new HttpGet("http://www.vazman.cn/search.php?vin="+vin);
            try {
                //3.执行get请求，相当于在输入地址栏后敲回车键
                response = httpClient.execute(httpGet);

                //4.判断响应状态为200，进行处理
                if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    //5.获取响应内容
                    HttpEntity httpEntity = response.getEntity();
                    String html = EntityUtils.toString(httpEntity, "utf-8");
                    //System.out.println(html);
                    model.addAttribute("status","1");
                    model.addAttribute("html",html);
                } else {
                    //如果返回状态不是200，比如404（页面不存在）等，根据情况做处理，这里略
                    String html = "返回状态不是200";
                    model.addAttribute("html",html);
                    model.addAttribute("status","0");
                    System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
                }
            } catch (ClientProtocolException e) {
                //e.printStackTrace();
                String html = "无网络呀！该数据为调用第三方数据接口，请连接网络再来查哦！~";
                model.addAttribute("html",html);
                model.addAttribute("status","0");
            } catch (IOException e) {
                //e.printStackTrace();
                String html = "无网络呀！该数据为调用第三方数据接口，请连接网络再来查哦！~";
                model.addAttribute("html",html);
                model.addAttribute("status","0");
            } finally {
                //6.关闭
                HttpClientUtils.closeQuietly(response);
                HttpClientUtils.closeQuietly(httpClient);
            }
            return "home/vin";
        }else{
            return "redirect:/Home/index";
        }
    }

    /**
     * 去登录页面
     */
    @RequestMapping("/login")
    public String login() {
        return "home/login";
    }

    /**
     * 登录方法
     */
    @ResponseBody
    @RequestMapping(value = "/loginAction",method = RequestMethod.POST)
    public JSONObject loginAction(@RequestBody String request, HttpSession session) {
        JSONObject jsonObject = JSONObject.parseObject(request);
        Map<String,Object> map = (Map<String,Object>)jsonObject;
        String username = String.valueOf(map.get("username"));
        String password = String.valueOf(map.get("password"));
        User user = new User();
        user = indexService.loginAction(username,password);
        if (user!=null){
            session.setAttribute("user",user);
            System.out.println(user);
            jsonObject.put("status", "success");
        }else{
            jsonObject.put("status", "fail");
        }
        return jsonObject;
    }

    /**
     * 退出登录方法
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/Home/index";
    }

    /**
     * 我的维修保养记录
     */
    @RequestMapping("/myMakrs")
    public String myMakrs(HttpServletRequest request,HttpSession session,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,Model model){
        User u = (User)session.getAttribute("user");
        String search = request.getParameter("search");
        if (u!=null){
            PageHelper.startPage(pageNo,pageSize);
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(indexService.myMakrs(u.getId(),search));
            System.out.println(pageInfo);
            model.addAttribute(pageInfo);
            return "home/user_marks";
        }else{
            return "redirect:/Home/login";
        }
    }

    /**
     * 我的留言咨询记录
     */
    @RequestMapping("/myComments")
    public String myComments(HttpServletRequest request,HttpSession session,@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize,Model model){
        User u = (User)session.getAttribute("user");
        if (u!=null){
            PageHelper.startPage(pageNo,pageSize);
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(indexService.myComments(u.getId()));
            System.out.println(pageInfo);
            model.addAttribute(pageInfo);
            return "home/user_liuyan";
        }else{
            return "redirect:/Home/login";
        }
    }

    /**
     * 查看留言
     */
    @RequestMapping("/ChakanLiuyan")
    public String ChakanLiuyan(HttpServletRequest request,HttpSession session,Model model){
        User u = (User)session.getAttribute("user");
        int id = Integer.parseInt(request.getParameter("id"));
        if (u!=null){
            Liuyan liuyan = indexService.ChakanLiuyan(id);
            Huifu huifu = indexService.getHuifuById(id);
            model.addAttribute("liuyan",liuyan);
            model.addAttribute("huifu",huifu);
            return "home/liuyan_detail";
        }else{
            return "redirect:/Home/login";
        }
    }

    /**
     * 添加留言
     */
    @RequestMapping("/liuyanAction")
    public String liuyanAction(HttpServletRequest request,HttpSession session,Model model){
        User u = (User)session.getAttribute("user");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        if (u!=null){
            Liuyan liuyan = new Liuyan();
            Timestamp ts = new Timestamp(new Date().getTime());
            liuyan.setUserid(u.getId());
            liuyan.setContent(content);
            liuyan.setTitle(title);
            liuyan.setStatus(1);
            liuyan.setCreateat(ts);
            System.out.println(indexService.liuyanAction(liuyan));
            return "redirect:/Home/myComments";
        }else{
            return "redirect:/Home/login";
        }
    }

}
