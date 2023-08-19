package com.example.stocks_feed_api.jwt;

import com.example.stocks_feed_api.dto.SignInRequest;
import com.example.stocks_feed_api.dto.SignUpRequest;

public interface AuthenticationService {
    String signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
