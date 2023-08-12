package com.example.stocks_feed_api.config;

import com.example.stocks_feed_api.model.Share;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class ShareConfiguration {
    @Bean
    ReactiveRedisOperations<String, Share> redisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<Share> serializer = new Jackson2JsonRedisSerializer<>(Share.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, Share> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, Share> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }

}
