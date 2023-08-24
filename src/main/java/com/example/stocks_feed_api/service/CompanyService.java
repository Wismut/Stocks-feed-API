package com.example.stocks_feed_api.service;

import com.example.stocks_feed_api.model.Company;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.ReactiveListOperations;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class CompanyService {
    private final ReactiveStringRedisTemplate redisTemplate;
    private ReactiveListOperations<String, String> reactiveListOps;

    @PostConstruct
    public void postConstruct() {
        reactiveListOps = redisTemplate.opsForList();
    }
}
