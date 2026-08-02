package com.supratim.service;

import com.supratim.exceptions.UserException;
import com.supratim.payload.dto.UserDto;
import com.supratim.payload.response.AuthResponse;

public interface AuthService {

    AuthResponse signup(UserDto userDto) throws UserException;
    AuthResponse login(UserDto userDto) throws UserException;
}
