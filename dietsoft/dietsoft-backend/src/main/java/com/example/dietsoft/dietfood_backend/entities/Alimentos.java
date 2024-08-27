package com.example.dietsoft.dietfood_backend.entities;

import com.example.dietsoft.dietfood_backend.entities.enums.CategoriaAlimentos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_alimentos")
@NoArgsConstructor
@Data
public class Alimentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double qtdProteina;
    private Double qtdCarbo;

    public Alimentos(Long id, String name, Double qtdProteina, Double qtdCarbo, Double caloria, Double qtdGordura, Double qtdFibra, Double qtdSodio, Double qtdAcucares, CategoriaAlimentos categoria, Double porcao, String medidaCaseira) {
        this.id = id;
        this.name = name;
        this.qtdProteina = qtdProteina;
        this.qtdCarbo = qtdCarbo;
        this.caloria = caloria;
        this.qtdGordura = qtdGordura;
        this.qtdFibra = qtdFibra;
        this.qtdSodio = qtdSodio;
        this.qtdAcucares = qtdAcucares;
        this.categoria = categoria;
        this.porcao = porcao;
        this.medidaCaseira = medidaCaseira;
    }

    public Alimentos(String name, Double qtdProteina, Double qtdCarbo, Double caloria, Double qtdGordura, Double qtdFibra, Double qtdSodio, Double qtdAcucares, CategoriaAlimentos categoria, Double porcao, String medidaCaseira) {
        this.name = name;
        this.qtdProteina = qtdProteina;
        this.qtdCarbo = qtdCarbo;
        this.caloria = caloria;
        this.qtdGordura = qtdGordura;
        this.qtdFibra = qtdFibra;
        this.qtdSodio = qtdSodio;
        this.qtdAcucares = qtdAcucares;
        this.categoria = categoria;
        this.porcao = porcao;
        this.medidaCaseira = medidaCaseira;
    }

    private Double caloria;
    private Double qtdGordura;
    private Double qtdFibra;
    private Double qtdSodio;
    private Double qtdAcucares;
    @Enumerated(EnumType.STRING)
    private CategoriaAlimentos categoria;
    private Double porcao;//em gramas
    private String medidaCaseira;

}
