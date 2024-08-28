package com.example.dietsoft.dietfood_backend.entities.enums;

import lombok.ToString;

@ToString
public enum AtividadesFisicasEnum {
    CAMINHADA_LEVE,
    TAREFAS_DOMESTICAS,
    ANDAR_BICICLETA_CASUAL,
    JARDINAGEM,
    SUBIR_ESCADAS_DEVAGAR,

    // Atividades Físicas Moderadas
    CAMINHADA_RAPIDA,
    NATACAO_MODERADA,
    DANCA,
    CORRIDA_LEVE,
    ANDAR_BICICLETA_MODERADO,

    // Atividades Físicas Intensas
    CORRIDA_INTENSA,
    ANDAR_BICICLETA_INTENSO,
    TREINAMENTO_FORCA,
    NATACAO_INTENSA,
    PULAR_CORDA;
}
