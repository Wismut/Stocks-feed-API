package com.example.stocks_feed_api.repository;

import com.example.stocks_feed_api.config.ObjectMapperUtils;
import com.example.stocks_feed_api.model.Stock;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import static com.example.stocks_feed_api.config.ObjectMapperUtils.STOCK_KEY;

@Repository
@AllArgsConstructor
public class RedisStockRepository implements StockRepository {
    private final ReactiveRedisComponent reactiveRedisComponent;

    @Override
    public Mono<Stock> findByCode(@NonNull String code) {
        return reactiveRedisComponent.get(STOCK_KEY, code).flatMap(d -> Mono.just(ObjectMapperUtils.objectMapper(d, Stock.class)));
    }
}
