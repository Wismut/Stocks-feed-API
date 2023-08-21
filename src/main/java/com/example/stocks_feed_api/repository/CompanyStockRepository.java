package com.example.stocks_feed_api.repository;

import com.example.stocks_feed_api.config.ObjectMapperUtils;
import com.example.stocks_feed_api.model.Company;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import static com.example.stocks_feed_api.config.ObjectMapperUtils.COMPANY_KEY;

@Repository
@AllArgsConstructor
public class CompanyStockRepository implements CompanyRepository {
    private final ReactiveRedisComponent reactiveRedisComponent;

    @Override
    public Flux<Company> findAll() {
        return reactiveRedisComponent.get(COMPANY_KEY).map(b -> ObjectMapperUtils.objectMapper(b, Company.class))
                .collectList().flatMapMany(Flux::fromIterable);
    }
}
