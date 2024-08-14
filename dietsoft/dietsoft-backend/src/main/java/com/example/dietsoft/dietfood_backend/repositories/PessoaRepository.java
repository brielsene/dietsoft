package com.example.dietsoft.dietfood_backend.repositories;

import com.example.dietsoft.dietfood_backend.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
}
