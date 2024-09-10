package org.example.securingapi.repositories;

import org.example.securingapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);  // Custom query method to find a user by their username
}
