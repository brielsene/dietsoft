package com.example.dietsoft.dietfood_backend.dto;

import com.example.dietsoft.dietfood_backend.entities.CategoriaAlimentos;
import jakarta.validation.constraints.NotNull;


public record AlimentoRequestDto(
         @NotNull
         String name,
         String qtdProteina,
         String qtdCarbo,
         String caloria,
         Double qtdGordura,
         Double qtdFibra,
         Double qtdSodio,
         Double qtdAcucares,

         CategoriaAlimentos categoria,
         Double porcao,
         String medidaCaseira
) {
}
