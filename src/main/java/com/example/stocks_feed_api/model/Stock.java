package com.example.stocks_feed_api.model;

import lombok.Data;

@Data
public class Stock {
    private Integer id;
    private String name;
    private String code;
}
