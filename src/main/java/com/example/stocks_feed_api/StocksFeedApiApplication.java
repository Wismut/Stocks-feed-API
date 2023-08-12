package com.example.stocks_feed_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@EnableWebSecurity
@MapperScan("com.example.stocks_feed_api.repository")
@SpringBootApplication(exclude = {
//        SecurityAutoConfiguration.class,
//        UserDetailsServiceAutoConfiguration.class
})
public class StocksFeedApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(StocksFeedApiApplication.class, args);
    }
}
