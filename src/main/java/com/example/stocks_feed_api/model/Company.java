package com.example.stocks_feed_api.model;

import lombok.Data;

@Data
public class Company {
    private Integer id;
    private String name;
    private String symbol;
}
