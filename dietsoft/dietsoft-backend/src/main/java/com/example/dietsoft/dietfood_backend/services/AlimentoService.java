package com.example.dietsoft.dietfood_backend.services;

import com.example.dietsoft.dietfood_backend.dto.AlimentoRequestDto;
import com.example.dietsoft.dietfood_backend.dto.AlimentoResponseDto;
import com.example.dietsoft.dietfood_backend.entities.Alimentos;
import com.example.dietsoft.dietfood_backend.repositories.AlimentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentoService {
    private final AlimentoRepository alimentoRepository;

    public AlimentoService(AlimentoRepository alimentoRepository) {
        this.alimentoRepository = alimentoRepository;
    }

    public AlimentoResponseDto createNewAlimento(AlimentoRequestDto dto){
        Alimentos alimentos = new Alimentos();
        BeanUtils.copyProperties(dto, alimentos);
        Alimentos save = alimentoRepository.save(alimentos);

        if(save != null){
            AlimentoResponseDto alimentoResponseDto = new AlimentoResponseDto(
                    save.getId(),
                    save.getName(),
                    save.getQtdProteina(),
                    save.getQtdCarbo(),
                    save.getCaloria(),
                    save.getQtdGordura(),
                    save.getQtdFibra(),
                    save.getQtdSodio(),
                    save.getQtdAcucares(),
                    save.getCategoria(),
                    save.getPorcao(),
                    save.getMedidaCaseira()
            );
            return alimentoResponseDto;
        }


        return null;

    }
    public List<AlimentoResponseDto> returnAllAlimentos(){
        List<Alimentos> all = alimentoRepository.findAll();
        return all.stream().map(AlimentoResponseDto::new).toList();
    }
}

