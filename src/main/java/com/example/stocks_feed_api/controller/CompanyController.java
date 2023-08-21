package com.example.stocks_feed_api.controller;

import com.example.stocks_feed_api.model.Company;
import com.example.stocks_feed_api.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService service;

    @GetMapping
    public Flux<Company> findAll() {
        return service.findAll();
    }
}
