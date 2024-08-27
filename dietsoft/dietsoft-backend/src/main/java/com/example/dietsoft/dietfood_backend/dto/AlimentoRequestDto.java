package com.example.dietsoft.dietfood_backend.dto;

import com.example.dietsoft.dietfood_backend.entities.enums.CategoriaAlimentos;
import jakarta.validation.constraints.NotNull;


public record AlimentoRequestDto(
         @NotNull
         String name,
         Double qtdProteina,
         Double qtdCarbo,
         Double caloria,
         Double qtdGordura,
         Double qtdFibra,
         Double qtdSodio,
         Double qtdAcucares,

         CategoriaAlimentos categoria,
         Double porcao,
         String medidaCaseira
) {
}
