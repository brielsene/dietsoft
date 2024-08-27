package com.example.dietsoft.dietfood_backend.dto;

import com.example.dietsoft.dietfood_backend.entities.User;
import com.example.dietsoft.dietfood_backend.entities.enums.CategoriaIMC;
import com.example.dietsoft.dietfood_backend.entities.enums.SexoEnum;
import jakarta.persistence.*;

import java.util.Optional;
import java.util.UUID;

public record RequestPessoaDto(
        String apelido,
        double peso,
        double altura,
        SexoEnum sexoEnum,
        String objetivo,

        Integer idade,
        UUID uuidUser



) {
}
