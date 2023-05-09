package com.tanoh.demo.services;

import com.tanoh.demo.dto.SignUpDto;
import com.tanoh.demo.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDto signUp(SignUpDto user) {
        return new UserDto(1L, "Tanoh", "Armel", "login", "token");
    }

}
