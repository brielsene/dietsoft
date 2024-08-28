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

import java.util.*;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final UserRepository userRepository;

    private static final Map<String, Double>atividadesFisicas = new HashMap<>();

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

    public void calculoAcrescimoBasalAtividadesFisicas(UUID uuid){
            if(atividadesFisicas.isEmpty()){
                atividadesFisicas.put("CAMINHADA-LEVE", Double.valueOf(200));
                atividadesFisicas.put("TAREFAS-DOMESTICAS", Double.valueOf(150));
                atividadesFisicas.put("ANDAR-BICICLETA-CASUAL", Double.valueOf(280));
                atividadesFisicas.put("JARDINAGEM", Double.valueOf(250));
                atividadesFisicas.put("SUBIR-ESCADAS-DEVAGAR", Double.valueOf(300));

                // Atividades Físicas Moderadas
                atividadesFisicas.put("CAMINHADA-RAPIDA", Double.valueOf(300));
                atividadesFisicas.put("NATACAO-MODERADA", Double.valueOf(400));
                atividadesFisicas.put("DANCA", Double.valueOf(350));
                atividadesFisicas.put("CORRIDA-LEVE", Double.valueOf(500));
                atividadesFisicas.put("ANDAR-BICICLETA-MODERADO", Double.valueOf(400));

                // Atividades Físicas Intensas
                atividadesFisicas.put("CORRIDA-INTENSA", Double.valueOf(600));
                atividadesFisicas.put("ANDAR-BICICLETA-INTENSO", Double.valueOf(600));
                atividadesFisicas.put("TREINAMENTO-FORCA", Double.valueOf(400));
                atividadesFisicas.put("NATACAO-INTENSA", Double.valueOf(600));
                atividadesFisicas.put("PULAR-CORDA", Double.valueOf(700));
            }

//        Caminhada Leve (4 km/h): ~200-300 calorias por hora
//        Tarefas Domésticas (limpar, lavar pratos): ~150-250 calorias por hora
//        Andar de Bicicleta (casual, ~16 km/h): ~280-400 calorias por hora
//        Jardinagem: ~250-350 calorias por hora
//        Subir Escadas (devagar): ~300-400 calorias por hora
//        2. Atividades Físicas Moderadas
//        Caminhada Rápida (6 km/h): ~300-400 calorias por hora
//        Natação (moderada): ~400-500 calorias por hora
//        Dança: ~350-450 calorias por hora
//        Corrida Leve (8 km/h): ~500-600 calorias por hora
//        Andar de Bicicleta (moderado, ~20 km/h): ~400-600 calorias por hora
//        3. Atividades Físicas Intensas
//        Corrida (10 km/h): ~600-800 calorias por hora
//        Andar de Bicicleta (intenso, ~25 km/h): ~600-900 calorias por hora
//        Treinamento de Força/Musculação (intenso): ~400-600 calorias por hora
//        Natação (intensa): ~600-750 calorias por hora
//        Pular Corda: ~700-1000 calorias por hora

    }
}
