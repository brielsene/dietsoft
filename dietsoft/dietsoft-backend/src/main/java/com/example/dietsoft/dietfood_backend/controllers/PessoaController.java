package com.example.dietsoft.dietfood_backend.controllers;

import com.example.dietsoft.dietfood_backend.dto.RequestActiviewsPhysicialDTO;
import com.example.dietsoft.dietfood_backend.dto.RequestPessoaDto;
import com.example.dietsoft.dietfood_backend.entities.Pessoa;
import com.example.dietsoft.dietfood_backend.services.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @PostMapping("/calculate-gasto-basal/{id}")
    public ResponseEntity calcGastoBasal(@PathVariable("id") String uuidstr){
        UUID uuid = UUID.fromString(uuidstr);
        double v = pessoaService.calculoGastoBasal(uuid);
        if(v == 0){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("erro to calcule gasto basal");
        }
        return ResponseEntity.ok(v);

    }

    @PostMapping("/add-calorias-phyisical-activies")
    public ResponseEntity addCaloricsPhyisical(@RequestBody RequestActiviewsPhysicialDTO dto){
        Double v = pessoaService.calculoAcrescimoBasalAtividadesFisicas(dto);
        if(v != null){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
