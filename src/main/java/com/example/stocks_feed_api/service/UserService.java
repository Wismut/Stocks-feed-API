package com.example.stocks_feed_api.service;

import com.example.stocks_feed_api.mapper.UserMapper;
import com.example.stocks_feed_api.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Service;

@XSlf4j
@Service
@AllArgsConstructor
public class UserService {
    private UserMapper userMapper;

    public void save(User user) {
        log.entry(user);
        userMapper.save(user);
        log.exit(user);
    }
}
