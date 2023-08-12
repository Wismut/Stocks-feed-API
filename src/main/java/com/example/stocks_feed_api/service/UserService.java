package com.example.stocks_feed_api.service;

import com.example.stocks_feed_api.dto.UserDto;
import com.example.stocks_feed_api.exception.UserAlreadyExistException;
import com.example.stocks_feed_api.mapper.UserMapper;
import com.example.stocks_feed_api.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@XSlf4j
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public void register(@NonNull UserDto userDto) {
        log.entry(userDto);
        if (usernameExists(userDto.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that username: "
                    + userDto.getUsername());
        }
        userRepository.save(UserMapper.INSTANCE.toModel(userDto));
        log.exit(userDto);
    }

    private boolean usernameExists(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
