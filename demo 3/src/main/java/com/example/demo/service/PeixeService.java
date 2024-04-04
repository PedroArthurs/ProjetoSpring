package com.example.demo.service;

import com.example.demo.model.Peixe;
import com.example.demo.repository.PeixeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeixeService implements AnimalService{

    @Autowired
     PeixeRepository peixeRepository;

    public List<Peixe> listarPeixes() {
        return peixeRepository.findAll();
    }

    public Peixe criar(Peixe peixe) {
        return peixeRepository.save(peixe);
    }

    public Peixe atualizar(Long id, Peixe peixe) {
        if (peixeRepository.existsById(id)) {
            peixe.setId(id);
            return peixeRepository.save(peixe);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if (peixeRepository.existsById(id)) {
            peixeRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public Optional<Peixe> buscarPorId(Long id) {
        return peixeRepository.findById(id);
    }

    @Override
    public List<Long> listarIds() {
        List<Peixe> peixes = peixeRepository.findAll();
        return peixes.stream()
                .map(Peixe::getId)
                .collect(Collectors.toList());
    }

    @Override
    public int qtd() {
        return peixeRepository.findAll().size();
    }
}
