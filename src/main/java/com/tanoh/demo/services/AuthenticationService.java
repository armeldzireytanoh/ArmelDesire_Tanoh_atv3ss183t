package com.tanoh.demo.services;

import com.tanoh.demo.dto.CredentialsDto;
import com.tanoh.demo.dto.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto authenticate(CredentialsDto credentialsDto) {
        String encodedMasterPassword = passwordEncoder.encode(CharBuffer.wrap("the-password"));
        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), encodedMasterPassword)) {
            return new UserDto(1L, "Tanoh", "Armel", "login", "token");
        }
        throw new RuntimeException("Invalid password");
    }

    public UserDto findByLogin(String login) {
        if ("login".equals(login)) {
            return new UserDto(1L, "Tanoh", "Armel", "login", "token");
        }
        throw new RuntimeException("Invalid login");
    }

}
