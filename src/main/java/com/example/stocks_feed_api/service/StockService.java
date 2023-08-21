package com.example.stocks_feed_api.service;

import com.example.stocks_feed_api.model.Stock;
import com.example.stocks_feed_api.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class StockService {
    private final StockRepository repository;

    public Mono<Stock> findByCode(String code) {
        return repository.findByCode(code);
    }
}
