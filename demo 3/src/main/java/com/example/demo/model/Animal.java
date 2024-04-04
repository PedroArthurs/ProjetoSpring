package com.example.demo.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Animal {

    private String nome;
    private String especie;
    private String idade;

    public Animal() {
    }

    public Animal(String nome, String especie, String idade) {
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void setId(Long id) {
    }
}
