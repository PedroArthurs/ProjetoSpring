package com.example.demo.service;


import com.example.demo.model.Reptil;
import com.example.demo.repository.ReptilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReptilService implements AnimalService{

    @Autowired
    ReptilRepository reptilRepository;

    public List<Reptil> listarRepteis() {
        return reptilRepository.findAll();
    }

    public Reptil criar(Reptil reptil) {
        return reptilRepository.save(reptil);
    }

    public Reptil atualizar(Long id, Reptil reptil) {
        if (reptilRepository.existsById(id)) {
            reptil.setId(id);
            return reptilRepository.save(reptil);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if (reptilRepository.existsById(id)) {
            reptilRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Reptil> buscarPorId(Long id) {
        return reptilRepository.findById(id);
    }

    @Override
    public List<Long> listarIds() {
        List<Reptil> reptils = reptilRepository.findAll();
        return reptils.stream()
                .map(Reptil::getId)
                .collect(Collectors.toList());
    }

    @Override
    public int qtd() {
        return reptilRepository.findAll().size();
    }
}
