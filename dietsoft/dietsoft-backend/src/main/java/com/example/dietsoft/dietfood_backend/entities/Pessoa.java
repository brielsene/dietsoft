package com.example.dietsoft.dietfood_backend.entities;

import com.example.dietsoft.dietfood_backend.entities.enums.CategoriaIMC;
import com.example.dietsoft.dietfood_backend.entities.enums.ObjetivoEnum;
import com.example.dietsoft.dietfood_backend.entities.enums.SexoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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
    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;
    private double peso;//KG
    private double altura;//METROS
    private double imc;
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria_imc")
    private CategoriaIMC categoriaIMC;
    @Enumerated(EnumType.STRING)
    private ObjetivoEnum objetivo;
    private Integer idade;
    private double gastoBasal;
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diet> diet;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
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

    public void setObjetoManual(ObjetivoEnum objetivo){
        this.objetivo = objetivo;
    }

    public void definirObjetivoDeAcordoComIMC(){
        switch(this.categoriaIMC) {
            case ABAIXO_DO_PESO:
                this.objetivo =  ObjetivoEnum.GANHAR_MASSA;
                break;
            case PESO_NORMAL:
                this.objetivo = ObjetivoEnum.MANTER;
                break;
            case SOBREPESO:
                this.objetivo = ObjetivoEnum.PERDER_GORDURA;
                break;
            case OBESIDADE_GRAU_1:
                this.objetivo = ObjetivoEnum.PERDER_GORDURA;
                break;
            case OBESIDADE_GRAU_2:
                this.objetivo = ObjetivoEnum.PERDER_GORDURA;
                break;
            case OBESIDADE_GRAU_3:
                this.objetivo = ObjetivoEnum.PERDER_GORDURA;
                break;
            default:
                this.objetivo = ObjetivoEnum.INDEFINIDO;
                break;
        }
    }

}


