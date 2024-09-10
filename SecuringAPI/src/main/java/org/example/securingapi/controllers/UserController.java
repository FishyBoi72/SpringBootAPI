package org.example.securingapi.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/jwt/admin")
    public String jwtAdminAccess() {
        return "Admin access with JWT";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/jwt/user")
    public String jwtUserAccess() {
        return "User access with JWT";
    }

    @GetMapping("/oauth2/welcome")
    public String oauth2Welcome() {
        return "Welcome with OAuth2";
    }
}
