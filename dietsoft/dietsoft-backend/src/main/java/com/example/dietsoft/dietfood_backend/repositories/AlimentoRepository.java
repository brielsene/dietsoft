package com.example.dietsoft.dietfood_backend.repositories;

import com.example.dietsoft.dietfood_backend.entities.Alimentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<Alimentos, Long> {
}
