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
        pessoa.setSexo(dto.sexoEnum());
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
        double calcGastoBasal = 0;
        double alturaEmCms = 0;
        if(pessoa.getAltura()<3){
            //CONVERTER PARA CMS
            alturaEmCms = pessoa.getAltura()*100;
        }
        if(pessoa.getSexo().equals(SexoEnum.MASCULINO)){

             calcGastoBasal= 66 + (13.8 * pessoa.getPeso() + (5* alturaEmCms - (6.8 * pessoa.getIdade())));
             pessoa.setGastoBasal(calcGastoBasal);
             pessoaRepository.save(pessoa);
        }else if(pessoa.getSexo().equals(SexoEnum.FEMININO)){
            calcGastoBasal = 655 + (9.6 * pessoa.getPeso()) + (1.8 * alturaEmCms) - (4.7 * pessoa.getIdade());
        }

        return calcGastoBasal;
    }
}
