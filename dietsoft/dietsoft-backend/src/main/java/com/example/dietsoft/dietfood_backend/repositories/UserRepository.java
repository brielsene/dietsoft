package com.example.dietsoft.dietfood_backend.repositories;

import com.example.dietsoft.dietfood_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    //Optional<User> getUserById(Long userId);

    Optional<User> getUserByEmail(String userEmail);
}
