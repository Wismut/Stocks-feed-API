package com.example.stocks_feed_api.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Share {
    private Long id;
    private String companyName;
    private String symbol;
    private double price;
    private LocalDateTime dateTime;
}
