package com.example.dietsoft.dietfood_backend.infra.exceptions;

public class SaveAlimentoInvalidException extends RuntimeException{
    public SaveAlimentoInvalidException(String msg){
        super(msg);
    }
}
