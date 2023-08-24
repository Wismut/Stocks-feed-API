package com.example.stocks_feed_api.config;

import com.example.stocks_feed_api.model.Company;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CompanyConfiguration {
    @Bean()
    @Qualifier("companyRedisFactory")
    public LettuceConnectionFactory companyRedisFactory() {
        return new LettuceConnectionFactory(
                new RedisStandaloneConfiguration()
        );
    }

    @Bean()
    @Qualifier("tokenRedisTemplate")
    public RedisTemplate<String, Company> tokenRedisTemplate(@Qualifier("companyRedisFactory") LettuceConnectionFactory companyRedisFactory) {
        RedisTemplate<String, Company> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(companyRedisFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Company.class));
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Company.class));
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
