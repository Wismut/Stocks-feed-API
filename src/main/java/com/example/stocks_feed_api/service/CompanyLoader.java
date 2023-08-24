package com.example.stocks_feed_api.service;

import com.example.stocks_feed_api.model.Company;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import net.datafaker.Faker;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;

@Component
@AllArgsConstructor
public class CompanyLoader {
    private final ReactiveRedisConnectionFactory factory;
    private final ReactiveRedisOperations<String, Company> companyOps;

    @PostConstruct
    public void loadData() {
        var id = new int[1];
        var faker = new Faker();
        List<net.datafaker.providers.base.Company> companies = faker.collection(faker::company).len(1000).generate();
        factory.getReactiveConnection().serverCommands().flushAll().thenMany(
                        Flux.fromIterable(companies)
                                .map(company -> companyOps.opsForValue().set("", new Company(id[0]++, company.name(), company.bs()))))
                .thenMany(companyOps.keys("*")
                        .flatMap(companyOps.opsForValue()::get))
                .subscribe(System.out::println);
    }
}
