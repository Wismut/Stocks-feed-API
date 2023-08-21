package com.example.stocks_feed_api.repository;

import com.example.stocks_feed_api.model.Stock;
import org.springframework.lang.NonNull;
import reactor.core.publisher.Mono;

public interface StockRepository {
    Mono<Stock> findByCode(@NonNull String code);
}
