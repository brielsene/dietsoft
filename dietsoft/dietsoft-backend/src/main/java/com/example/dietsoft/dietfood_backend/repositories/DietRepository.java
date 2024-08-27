package com.example.dietsoft.dietfood_backend.repositories;

import com.example.dietsoft.dietfood_backend.entities.Diet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DietRepository extends JpaRepository<Diet, UUID> {
}
