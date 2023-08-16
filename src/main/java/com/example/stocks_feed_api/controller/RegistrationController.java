package com.example.stocks_feed_api.controller;

import com.example.stocks_feed_api.dto.UserDto;
import com.example.stocks_feed_api.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/register")
public class RegistrationController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public void save(@RequestBody UserDto userDto) {
        userService.register(userDto);
    }
}
