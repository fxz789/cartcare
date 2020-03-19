package com.example.cartcare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan("com.example.*")//包扫描
@EnableWebMvc//将@EnableWebMvc添加给@Configuration类来导入SpringMvc的配置
@EnableTransactionManagement//开启SpringBoot事务支持
@SpringBootApplication
public class CartcareApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartcareApplication.class, args);
    }

}
