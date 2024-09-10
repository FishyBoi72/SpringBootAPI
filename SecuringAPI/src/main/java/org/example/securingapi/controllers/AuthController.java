package org.example.securingapi.controllers;

import org.example.securingapi.models.AuthRequest;
import org.example.securingapi.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    // Retrieve user details by username
    @GetMapping("/user/{username}")
    public UserDetails getUserByUsername(@PathVariable String username) {
        return jwtUserDetailsService.loadUserByUsername(username);
    }

    // New login endpoint that authenticates the user
    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            // If authentication succeeds, generate and return a token (if JWT is used)
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return "Login successful!"; // Return a token if using JWT

        } catch (AuthenticationException e) {
            return "Login failed: " + e.getMessage();
        }
    }
}
