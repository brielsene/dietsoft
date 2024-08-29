package com.example.dietsoft.dietfood_backend.dto;

import com.example.dietsoft.dietfood_backend.entities.enums.AtividadesFisicasEnum;

import java.util.UUID;

public record RequestActiviewsPhysicialDTO(
        UUID uuid,
        AtividadesFisicasEnum atividadesFisicasEnum

) {
}
