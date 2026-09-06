package com.auth_service.controller;

import com.auth_service.model.dto.UserDTO;
import com.auth_service.model.dto.AuthRequestDTO;
import com.auth_service.model.entity.UserInfo;
import com.auth_service.service.JwtService;
import com.auth_service.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserInfoService service;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome bi-";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserDTO userDTO) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(userDTO.getName());
        userInfo.setEmail(userDTO.getEmail());
        userInfo.setPassword(userDTO.getPassword());
        userInfo.setRoles(userDTO.getRoles());

        return service.addUser(userInfo);
    }

    @PostMapping("/generateToken")
    public String authenticationAndGetToken(@RequestBody AuthRequestDTO authRequest) {
        System.out.println("a");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        //System.out.println("Authentication" + authentication);
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }

}
