package com.example.stocks_feed_api.repository;

import com.example.stocks_feed_api.model.Company;
import reactor.core.publisher.Flux;

public interface CompanyRepository {
    Flux<Company> findAll();
}
