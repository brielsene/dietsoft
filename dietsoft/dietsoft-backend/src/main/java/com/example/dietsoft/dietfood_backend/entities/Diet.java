package com.example.dietsoft.dietfood_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_diets")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private String description;
    @Column(name = "date_of_diet")
    private LocalDateTime dateOfDiet;
    private String author;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Alimentos>alimentos;
}
