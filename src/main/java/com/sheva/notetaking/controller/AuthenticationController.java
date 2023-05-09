package com.sheva.notetaking.controller;

import com.sheva.notetaking.auth.AuthenticationRequest;
import com.sheva.notetaking.auth.AuthenticationResponse;
import com.sheva.notetaking.auth.RegisterRequest;
import com.sheva.notetaking.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register-user")
    public ResponseEntity<AuthenticationResponse> registerUser(
            @RequestBody RegisterRequest request
    ) throws UnsupportedEncodingException {
        return ResponseEntity.ok(service.registerUser(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateUser(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticateUser(request));
    }

    @GetMapping("/session")
    public ResponseEntity<UserDetails> getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails name = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(name);
    }
}
