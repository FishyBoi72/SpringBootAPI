package org.example.securingapi.services;

import org.example.securingapi.models.Role;
import org.example.securingapi.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class RoleInitializationService {

    private final RoleRepository roleRepository;

    public RoleInitializationService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void init() {
        if (roleRepository.findByName("ROLE_USER") == null) {
            roleRepository.saveAll(Arrays.asList(
                    new Role("ROLE_USER"),
                    new Role("ROLE_ADMIN")
            ));
        }
    }
}
