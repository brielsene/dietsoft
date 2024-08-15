package com.example.dietsoft.dietfood_backend.controllers;

import com.example.dietsoft.dietfood_backend.dto.RequestPessoaDto;
import com.example.dietsoft.dietfood_backend.entities.Pessoa;
import com.example.dietsoft.dietfood_backend.services.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/create-pessoa")
    public ResponseEntity createPessoa(@RequestBody RequestPessoaDto dto){
        Pessoa pessoa = pessoaService.createPessoa(dto);
        if(pessoa == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error to create pessoa");
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
