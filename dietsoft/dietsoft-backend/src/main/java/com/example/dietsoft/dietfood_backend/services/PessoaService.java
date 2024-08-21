package com.example.dietsoft.dietfood_backend.services;

import com.example.dietsoft.dietfood_backend.dto.RequestPessoaDto;
import com.example.dietsoft.dietfood_backend.entities.Pessoa;
import com.example.dietsoft.dietfood_backend.entities.User;
import com.example.dietsoft.dietfood_backend.entities.enums.SexoEnum;
import com.example.dietsoft.dietfood_backend.repositories.PessoaRepository;
import com.example.dietsoft.dietfood_backend.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final UserRepository userRepository;

    public PessoaService(PessoaRepository pessoaRepository, UserRepository userRepository) {
        this.pessoaRepository = pessoaRepository;
        this.userRepository = userRepository;
    }

    public Pessoa createPessoa(RequestPessoaDto dto){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(dto, pessoa);
        pessoa.calcularImc();
        pessoa.definirCategoriaIMC();
        pessoa.setIdade(dto.idade());
        if(dto.objetivo() == null || dto.objetivo().isEmpty() || dto.objetivo().isBlank()){
            pessoa.definirObjetivoDeAcordoComIMC();
        }
        User byId = userRepository.findById(dto.uuidUser()).orElseThrow(() -> new RuntimeException("not found id with uuid"));
        pessoa.setUser(byId);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa searchPessoaById(UUID id){
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("not found"));
        return pessoa;
    }

    public double calculoGastoBasal(UUID uuid){
        Pessoa pessoa = searchPessoaById(uuid);
        //EXEMPLO CÁLCULO GASTO BASAL
//        Homens: 66 + (13,8 x peso em kg) + (5 x altura em cm) – (6,8 x idade em anos)
//
//
//        66 +(13,8 x 86)+(5 x 182) - (6,8 x 22)
//
//        66 + 1.186,8 + 910 - 149,6
//
//        2.012,4
        //homens
        double calcGastoBasal = 0;
        if(pessoa.getSexo().equals(SexoEnum.MASCULINO)){
            double alturaEmCms = 0;
            if(pessoa.getAltura()<3){
                //CONVERTER PARA CMS
                alturaEmCms = pessoa.getAltura()*100;
            }
             calcGastoBasal= 66 + (13.8 * pessoa.getPeso() + (5* alturaEmCms - (6.8 * pessoa.getIdade())));
             pessoa.setGastoBasal(calcGastoBasal);
             pessoaRepository.save(pessoa);
        }else if(pessoa.getSexo().equals(SexoEnum.FEMININO)){
            //FAZER A CONTA!!
        }

        return calcGastoBasal;
    }
}
