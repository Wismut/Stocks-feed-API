package com.example.stocks_feed_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.stocks_feed_api.repository")
public class StocksFeedApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(StocksFeedApiApplication.class, args);
    }
}
