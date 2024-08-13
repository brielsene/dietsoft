package com.example.dietsoft.dietfood_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_alimentos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Alimentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String qtdProteina;
    private String qtdCarbo;
    private String caloria;
    private Double qtdGordura;
    private Double qtdFibra;
    private Double qtdSodio;
    private Double qtdAcucares;
    @Enumerated(EnumType.STRING)
    private CategoriaAlimentos categoria;
    private Double porcao;
    private String medidaCaseira;

}
