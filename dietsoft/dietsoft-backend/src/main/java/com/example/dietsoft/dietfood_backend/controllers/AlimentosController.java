package com.example.dietsoft.dietfood_backend.controllers;

import com.example.dietsoft.dietfood_backend.dto.AlimentoRequestDto;
import com.example.dietsoft.dietfood_backend.dto.AlimentoResponseDto;
import com.example.dietsoft.dietfood_backend.services.AlimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alimentos")
public class AlimentosController {
    private final AlimentoService alimentoService;

    public AlimentosController(AlimentoService alimentoService) {
        this.alimentoService = alimentoService;
    }

    @PostMapping("/create-alimento")
    public ResponseEntity createAlimento(@RequestBody AlimentoRequestDto dto){
        AlimentoResponseDto newAlimento = alimentoService.createNewAlimento(dto);
        if (newAlimento == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newAlimento);
    }

    @PostMapping("/create-more-alimentos")
    public ResponseEntity createMoreAlimentos(@RequestBody List<AlimentoRequestDto>dto){
        alimentoService.createMoreAlimentos(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
