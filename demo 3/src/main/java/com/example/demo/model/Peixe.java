package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Peixe extends Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String habitat;

    @NotNull
    @Min(value = 1)
    private double profundidadeMaxima;

    public Peixe() {
    }

    public Peixe(String nome, String especie, String idade, String habitat, double profundidadeMaxima) {
        super(nome, especie, idade);
        this.habitat = habitat;
        this.profundidadeMaxima = profundidadeMaxima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public double getProfundidadeMaxima() {
        return profundidadeMaxima;
    }

    public void setProfundidadeMaxima(double profundidadeMaxima) {
        this.profundidadeMaxima = profundidadeMaxima;
    }
}
