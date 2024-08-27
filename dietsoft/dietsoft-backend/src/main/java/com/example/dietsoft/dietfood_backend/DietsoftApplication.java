package com.example.dietsoft.dietfood_backend;

import com.example.dietsoft.dietfood_backend.dto.RequestPessoaDto;
import com.example.dietsoft.dietfood_backend.dto.UserCreateDTO;
import com.example.dietsoft.dietfood_backend.dto.UserDTO;
import com.example.dietsoft.dietfood_backend.entities.Alimentos;
import com.example.dietsoft.dietfood_backend.entities.Pessoa;
import com.example.dietsoft.dietfood_backend.entities.User;
import com.example.dietsoft.dietfood_backend.entities.enums.CategoriaAlimentos;
import com.example.dietsoft.dietfood_backend.entities.enums.SexoEnum;
import com.example.dietsoft.dietfood_backend.repositories.AlimentoRepository;
import com.example.dietsoft.dietfood_backend.repositories.PessoaRepository;
import com.example.dietsoft.dietfood_backend.repositories.UserRepository;
import com.example.dietsoft.dietfood_backend.services.PessoaService;
import com.example.dietsoft.dietfood_backend.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class DietsoftApplication implements CommandLineRunner {

	private final AlimentoRepository repository;
	private final UserRepository userRepository;
	private final PessoaRepository pessoaRepository;

	private final PessoaService pessoaService;
	private final UserService userService;

    public DietsoftApplication(AlimentoRepository alimentosRepository, UserRepository userRepository, PessoaRepository pessoaRepository, PessoaService pessoaService, UserService userService) {
        this.repository = alimentosRepository;
        this.userRepository = userRepository;
        this.pessoaRepository = pessoaRepository;
        this.pessoaService = pessoaService;
        this.userService = userService;
    }

    public static void main(String[] args) {
		SpringApplication.run(DietsoftApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Inserindo Carboidratos
		repository.save(new Alimentos("Arroz", 2.7, 28.0, 130.0, 0.3, 0.4, 0.0, 0.0, CategoriaAlimentos.CARBOIDRATOS, 100.0, "1/2 xícara"));
		repository.save(new Alimentos("Macarrão", 5.8, 30.0, 157.0, 0.9, 1.8, 0.0, 0.0, CategoriaAlimentos.CARBOIDRATOS, 100.0, "1 xícara"));
		repository.save(new Alimentos("Batata", 2.0, 17.0, 77.0, 0.1, 2.2, 0.0, 0.0, CategoriaAlimentos.CARBOIDRATOS, 150.0, "1 unidade média"));

		// Inserindo Proteínas
		repository.save(new Alimentos("Carne Bovina", 26.0, 0.0, 250.0, 17.0, 0.0, 0.0, 0.0, CategoriaAlimentos.PROTEINAS, 100.0, "1 porção"));
		repository.save(new Alimentos("Peito de Frango", 31.0, 0.0, 165.0, 3.6, 0.0, 0.0, 0.0, CategoriaAlimentos.PROTEINAS, 100.0, "1 filé médio"));
		repository.save(new Alimentos("Ovo", 6.0, 1.0, 68.0, 5.0, 0.0, 0.0, 0.0, CategoriaAlimentos.PROTEINAS, 50.0, "1 unidade"));

		// Inserindo Gorduras Saudáveis
		repository.save(new Alimentos("Abacate", 2.0, 9.0, 160.0, 15.0, 7.0, 0.0, 0.5, CategoriaAlimentos.GORDURAS, 100.0, "1/2 unidade média"));
		repository.save(new Alimentos("Azeite de Oliva", 0.0, 0.0, 884.0, 100.0, 0.0, 0.0, 0.0, CategoriaAlimentos.GORDURAS, 15.0, "1 colher de sopa"));
		repository.save(new Alimentos("Amêndoas", 21.0, 22.0, 576.0, 49.0, 12.0, 0.0, 0.0, CategoriaAlimentos.GORDURAS, 30.0, "20 unidades"));

		// Inserindo Fibras
		repository.save(new Alimentos("Aveia", 17.0, 66.0, 389.0, 7.0, 11.0, 0.0, 0.4, CategoriaAlimentos.FIBRAS, 30.0, "2 colheres de sopa"));
		repository.save(new Alimentos("Lentilhas", 9.0, 20.0, 116.0, 0.4, 7.9, 0.0, 0.1, CategoriaAlimentos.FIBRAS, 100.0, "1/2 xícara"));
		repository.save(new Alimentos("Maçã", 0.3, 14.0, 52.0, 0.2, 2.4, 0.0, 10.0, CategoriaAlimentos.FIBRAS, 150.0, "1 unidade média"));

		// Inserindo Vitaminas e Minerais
		repository.save(new Alimentos("Espinafre", 2.9, 3.6, 23.0, 0.4, 2.2, 0.0, 0.1, CategoriaAlimentos.VITAMINAS_MINERAIS, 100.0, "1 xícara"));
		repository.save(new Alimentos("Cenoura", 0.9, 10.0, 41.0, 0.2, 2.8, 0.0, 0.1, CategoriaAlimentos.VITAMINAS_MINERAIS, 100.0, "1 unidade média"));
		repository.save(new Alimentos("Banana", 1.1, 23.0, 89.0, 0.3, 2.6, 0.0, 12.0, CategoriaAlimentos.VITAMINAS_MINERAIS, 120.0, "1 unidade média"));

		// Inserindo Antioxidantes
		repository.save(new Alimentos("Morango", 0.7, 7.7, 32.0, 0.3, 2.0, 0.0, 4.0, CategoriaAlimentos.ANTIOXIDANTES, 100.0, "7 unidades"));
		repository.save(new Alimentos("Mirtilo", 0.7, 14.0, 57.0, 0.3, 2.4, 0.0, 9.0, CategoriaAlimentos.ANTIOXIDANTES, 100.0, "1/2 xícara"));
		repository.save(new Alimentos("Chá Verde", 0.0, 0.2, 1.0, 0.0, 0.0, 0.0, 0.0, CategoriaAlimentos.ANTIOXIDANTES, 240.0, "1 xícara"));

		//ADICIONANDO USUARIO
		UserCreateDTO userCreateDTO = new UserCreateDTO("Gabriel", "gb@gmail.com", "483294832");
		User user = new User();
		BeanUtils.copyProperties(userCreateDTO, user);
		UserDTO user1 = userService.createUser(user);


		//CRIANDO PESSOA
		Pessoa pessoa = pessoaService.createPessoa(new RequestPessoaDto("GB", 86, 1.82, SexoEnum.MASCULINO, "Ganhar Massa", 22, user1.getUuid()));
		pessoaService.calculoGastoBasal(pessoa.getUuid());


	}
}
