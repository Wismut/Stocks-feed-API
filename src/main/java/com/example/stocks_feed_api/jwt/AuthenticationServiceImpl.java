package com.example.stocks_feed_api.jwt;

import com.example.stocks_feed_api.dto.SignInRequest;
import com.example.stocks_feed_api.dto.SignUpRequest;
import com.example.stocks_feed_api.model.Role;
import com.example.stocks_feed_api.model.User;
import com.example.stocks_feed_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthenticationService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder().username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        var jwt = jwtService.createToken(user.getUsername(), user.getPassword());
        user.setToken(jwt);
        userRepository.save(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername());
        if (isNull(user)) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        var jwt = jwtService.createToken(user.getUsername(), user.getPassword());
        user.setToken(jwt);
        userRepository.save(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
