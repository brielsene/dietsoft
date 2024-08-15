package com.example.dietsoft.dietfood_backend.dto;

import com.example.dietsoft.dietfood_backend.entities.User;
import com.example.dietsoft.dietfood_backend.entities.enums.CategoriaIMC;
import jakarta.persistence.*;

import java.util.Optional;
import java.util.UUID;

public record RequestPessoaDto(
        String apelido,
        double peso,
        double altura,
        String objetivo,
        UUID uuidUser



) {
}
