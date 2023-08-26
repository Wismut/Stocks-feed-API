package com.example.stocks_feed_api.service;

import com.example.stocks_feed_api.model.Company;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class CompanyService {
    public Flux<Company> findAll() {
        return null;
    }
}
