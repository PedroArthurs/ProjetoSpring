package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

//Repetil = funcionario
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Reptil extends Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Min(value = 1)
    private double temperaturaCorporal;

    public Reptil() {
    }

    public Reptil(String nome, String especie, String idade, double temperaturaCorporal) {
        super(nome, especie, idade);
        this.temperaturaCorporal = temperaturaCorporal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTemperaturaCorporal() {
        return temperaturaCorporal;
    }

    public void setTemperaturaCorporal(double temperaturaCorporal) {
        this.temperaturaCorporal = temperaturaCorporal;
    }
}
