package com.example.stocks_feed_api.controller;

import com.example.stocks_feed_api.model.Stock;
import com.example.stocks_feed_api.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api/stocks")
public class StockController {
    private final StockService service;

    @GetMapping("/{stock_code}/quote")
    public Mono<Stock> findByCode(@PathVariable("stock_code") String code) {
        return service.findByCode(code);
    }
}
