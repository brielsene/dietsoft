package com.example.dietsoft.dietfood_backend;

import com.example.dietsoft.dietfood_backend.entities.Alimentos;
import com.example.dietsoft.dietfood_backend.repositories.AlimentoRepository;
import com.example.dietsoft.dietfood_backend.repositories.AlimentosRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DietsoftApplication implements CommandLineRunner {

	private final AlimentoRepository repository;

    public DietsoftApplication(AlimentoRepository alimentosRepository) {
        this.repository = alimentosRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(DietsoftApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Alimentos("Arroz", "Carboidratos", 130, 28, 2.7, 0.3, 0.4));
		repository.save(new Alimentos("Macarrão", "Carboidratos", 157, 30, 5.8, 0.9, 1.8));
		repository.save(new Alimentos("Batata", "Carboidratos", 77, 17, 2.0, 0.1, 2.2));
		repository.save(new Alimentos("Pão Integral", "Carboidratos", 246, 43, 8.9, 3.4, 6.7));
		repository.save(new Alimentos("Aveia", "Carboidratos", 389, 66, 16.9, 6.9, 10.6));
		repository.save(new Alimentos("Banana", "Carboidratos", 89, 23, 1.1, 0.3, 2.6));

		// Inserindo Proteínas
		repository.save(new Alimentos("Carne Bovina", "Proteínas", 250, 0, 26, 17, 0));
		repository.save(new Alimentos("Peito de Frango", "Proteínas", 165, 0, 31, 3.6, 0));
		repository.save(new Alimentos("Ovo", "Proteínas", 68, 1, 6, 5, 0));
		repository.save(new Alimentos("Peixe", "Proteínas", 206, 0, 22, 12, 0));
		repository.save(new Alimentos("Queijo Cottage", "Proteínas", 98, 3.4, 11, 4.3, 0));
		repository.save(new Alimentos("Tofu", "Proteínas", 76, 1.9, 8, 4.8, 0));

		// Inserindo Gorduras
		repository.save(new Alimentos("Abacate", "Gorduras", 160, 9, 2, 15, 7));
		repository.save(new Alimentos("Azeite de Oliva", "Gorduras", 884, 0, 0, 100, 0));
		repository.save(new Alimentos("Castanha-do-Pará", "Gorduras", 656, 12, 14, 66, 8));
		repository.save(new Alimentos("Manteiga de Amendoim", "Gorduras", 588, 20, 25, 50, 6));
		repository.save(new Alimentos("Salmão", "Gorduras", 208, 0, 20, 13, 0));

		// Inserindo Fibras
		repository.save(new Alimentos("Feijão", "Fibras", 127, 23, 8.7, 0.5, 8.5));
		repository.save(new Alimentos("Lentilha", "Fibras", 116, 20, 9, 0.4, 7.9));
		repository.save(new Alimentos("Brócolis", "Fibras", 55, 11, 3.7, 0.6, 3.3));
		repository.save(new Alimentos("Maçã", "Fibras", 52, 14, 0.3, 0.2, 2.4));
		repository.save(new Alimentos("Chia", "Fibras", 486, 42, 16.5, 31, 34.4));

		// Inserindo Vitaminas
		repository.save(new Alimentos("Laranja", "Vitaminas", 43, 11, 0.9, 0.1, 2.4));
		repository.save(new Alimentos("Cenoura", "Vitaminas", 41, 10, 0.9, 0.2, 2.8));
		repository.save(new Alimentos("Espinafre", "Vitaminas", 23, 3.6, 2.9, 0.4, 2.2));
		repository.save(new Alimentos("Tomate", "Vitaminas", 18, 3.9, 0.9, 0.2, 1.2));
		repository.save(new Alimentos("Amêndoa", "Vitaminas", 579, 22, 21, 49, 12.5));

		// Inserindo Minerais
		repository.save(new Alimentos("Leite", "Minerais", 42, 5, 3.4, 1, 0));
		repository.save(new Alimentos("Iogurte", "Minerais", 59, 3.6, 10, 0.4, 0));
		repository.save(new Alimentos("Amendoim", "Minerais", 567, 16, 25, 49, 8.5));
		repository.save(new Alimentos("Couve", "Minerais", 50, 9, 4.3, 0.7, 3.6));
		repository.save(new Alimentos("Quinoa", "Minerais", 120, 21, 4.1, 1.9, 2.8));
	}
}
