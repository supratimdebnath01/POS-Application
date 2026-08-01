package com.supratim.service.impl;

import com.supratim.configuration.JwtProvider;
import com.supratim.domain.UsereRole;
import com.supratim.exceptions.UserException;
import com.supratim.mapper.UserMapper;
import com.supratim.modal.User;
import com.supratim.payload.dto.UserDto;
import com.supratim.payload.response.AuthResponse;
import com.supratim.repository.UserRepository;
import com.supratim.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final CustomUserImplementation customUserImplementation;



    @Override
    public AuthResponse signup(UserDto userDto) throws UserException {
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user != null) {
            throw new UserException("Email ID already registered !");
        }
        if (userDto.getRole().equals(UsereRole.ROLE_ADMIN)){
            throw new UserException("Role admin is not allowed !");
        }

        User newUser = new User();
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setRole(userDto.getRole());
        newUser.setFullName(userDto.getFullName());
        newUser.setPhone(userDto.getPhone());
        newUser.setLastLogin(LocalDateTime.now());
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());

        User savedUser =  userRepository.save(newUser);

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Register Successfully !");
        authResponse.setUser(UserMapper.toDTO(savedUser));


        return null;
    }

    @Override
    public AuthResponse login(UserDto userDto) {
        return null;
    }
}
