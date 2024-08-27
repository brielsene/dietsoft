package com.example.dietsoft.dietfood_backend.dto;

import com.example.dietsoft.dietfood_backend.entities.Alimentos;
import com.example.dietsoft.dietfood_backend.entities.enums.CategoriaAlimentos;

public record AlimentoResponseDto(
        Long id,
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
    public AlimentoResponseDto(Alimentos alimentos){
        this(alimentos.getId(), alimentos.getName(), alimentos.getQtdProteina(),
                alimentos.getQtdCarbo(), alimentos.getCaloria(), alimentos.getQtdGordura(),
                alimentos.getQtdFibra(), alimentos.getQtdSodio(), alimentos.getQtdAcucares(),
                alimentos.getCategoria(), alimentos.getPorcao(), alimentos.getMedidaCaseira());
    }
}
