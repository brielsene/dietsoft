package com.example.dietsoft.dietfood_backend.services;

import com.example.dietsoft.dietfood_backend.dto.RequestPessoaDto;
import com.example.dietsoft.dietfood_backend.entities.Pessoa;
import com.example.dietsoft.dietfood_backend.entities.User;
import com.example.dietsoft.dietfood_backend.repositories.PessoaRepository;
import com.example.dietsoft.dietfood_backend.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        if(dto.objetivo() == null || dto.objetivo().isEmpty() || dto.objetivo().isBlank()){
            pessoa.definirObjetivoDeAcordoComIMC();
        }
        User byId = userRepository.findById(dto.uuidUser()).orElseThrow(() -> new RuntimeException("not found id with uuid"));
        pessoa.setUser(byId);
        return pessoaRepository.save(pessoa);
    }
}
