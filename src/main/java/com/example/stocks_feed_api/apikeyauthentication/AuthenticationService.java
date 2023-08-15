package com.example.stocks_feed_api.apikeyauthentication;

import com.example.stocks_feed_api.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final UserService userService;

    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
    private static final String AUTH_TOKEN = "my_secret_api_key";

    public Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if (apiKey == null) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}
