package com.example.dietsoft.dietfood_backend.entities;

import com.example.dietsoft.dietfood_backend.entities.enums.CategoriaIMC;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tb_pessoas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private UUID uuid;
    private String apelido;

    private double peso;
    private double altura;
    private double imc;
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_imc")
    private CategoriaIMC categoriaIMC;
    private String objetivo;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;


    public void calcularImc(){
        this.imc = this.peso/(altura*2);
    }

    public void definirCategoriaIMC(){
            if(this.imc < 18.5){
                categoriaIMC = CategoriaIMC.ABAIXO_DO_PESO;
            } else if(this.imc >= 18.5 && this.imc < 24.9){
                categoriaIMC = CategoriaIMC.PESO_NORMAL;
            } else if(this.imc >= 24.9 && this.imc < 29.9){
                categoriaIMC = CategoriaIMC.SOBREPESO;
            } else if(this.imc >= 29.9 && this.imc < 34.9){
                categoriaIMC = CategoriaIMC.OBESIDADE_GRAU_1;
            } else if(this.imc >= 34.9 && this.imc < 39.9){
                categoriaIMC = CategoriaIMC.OBESIDADE_GRAU_2;
            } else if(this.imc >= 40){
                categoriaIMC = CategoriaIMC.OBESIDADE_GRAU_3;
            }

    }

    public void definirObjetivoDeAcordoComIMC(){
        switch(this.categoriaIMC) {
            case ABAIXO_DO_PESO:
                this.objetivo = "Ganhar Massa";
                break;
            case PESO_NORMAL:
                this.objetivo = "Manter Peso";
                break;
            case SOBREPESO:
                this.objetivo = "Perder Peso";
                break;
            case OBESIDADE_GRAU_1:
                this.objetivo = "Perder Peso com Monitoramento";
                break;
            case OBESIDADE_GRAU_2:
                this.objetivo = "Perder Peso com Assistência Médica";
                break;
            case OBESIDADE_GRAU_3:
                this.objetivo = "Perder Peso com Suporte Intensivo";
                break;
            default:
                this.objetivo = "Objetivo Indefinido";
                break;
        }
    }

}


