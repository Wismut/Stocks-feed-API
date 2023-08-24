package com.example.stocks_feed_api.service;

import com.example.stocks_feed_api.model.Stock;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StockService {
    @Autowired
    private ReactiveRedisTemplate<String, Stock> redisTemplate;
    private ReactiveValueOperations<String, Stock> reactiveValueOps;

    @PostConstruct
    public void setup() {
        reactiveValueOps = redisTemplate.opsForValue();
    }
}
