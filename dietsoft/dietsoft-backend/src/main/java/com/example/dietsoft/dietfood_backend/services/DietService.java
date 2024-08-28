package com.example.dietsoft.dietfood_backend.services;

import com.example.dietsoft.dietfood_backend.dto.DietRequestDTO;
import com.example.dietsoft.dietfood_backend.dto.DietRespondeDTO;
import com.example.dietsoft.dietfood_backend.dto.PorcentagemNutrientesDTO;
import com.example.dietsoft.dietfood_backend.entities.Pessoa;
import com.example.dietsoft.dietfood_backend.entities.enums.ObjetivoEnum;
import com.example.dietsoft.dietfood_backend.repositories.DietRepository;
import org.springframework.stereotype.Service;

@Service
public class DietService {
    private final DietRepository dietRepository;
    private final PessoaService pessoaService;

    public DietService(DietRepository dietRepository, PessoaService pessoaService) {
        this.dietRepository = dietRepository;
        this.pessoaService = pessoaService;
    }

    public DietRespondeDTO createDiet(DietRequestDTO dietRequestDTO){

        Pessoa pessoa = pessoaService.searchPessoaById(dietRequestDTO.idPessoa());
        Double gastoBasal = null;
        if(pessoa != null){
            gastoBasal = pessoa.getGastoBasal();
            if(gastoBasal != null){

            }
        }
        return null;
    }

    public PorcentagemNutrientesDTO porcentagemNutrientesDTO(Double gastoCaloricoBasal, ObjetivoEnum objetivo){
        if (objetivo.equals(ObjetivoEnum.GANHAR_MASSA)) {
            //+400
        }else if(objetivo.equals(ObjetivoEnum.PERDER_GORDURA)) {
            //-400
        }else if(objetivo.equals(ObjetivoEnum.MANTER)){
            //0
        }else if(objetivo.equals(ObjetivoEnum.INDEFINIDO)){

        }
        Double proteinas = gastoCaloricoBasal * 0;
        return null;

    }


}
