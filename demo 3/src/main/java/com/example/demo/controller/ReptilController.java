package com.example.demo.controller;


import com.example.demo.model.Reptil;
import com.example.demo.service.ReptilService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/repteis")
public class ReptilController {

    @Autowired
    ReptilService reptilService;

    @GetMapping
    public List<Reptil> listarRepteis() {
        return reptilService.listarRepteis();
    }

    @PostMapping
    public Reptil criar(@Valid @RequestBody Reptil reptil) {
        return reptilService.criar(reptil);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Reptil reptil) {
        if (reptilService.atualizar(id, reptil) == null) {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(reptil);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if (reptilService.deletar(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/qtd")
    public int qtdRepteis() {
        return reptilService.qtd();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Reptil> reptilOptional = reptilService.buscarPorId(id);
        if (reptilOptional.isPresent()) {
            Reptil reptil = reptilOptional.get();
            return ResponseEntity.ok(reptil);
        } else {
            String mensagem = "Reptil com o ID " + id + " não encontrado.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/ids")
    public List<Long> listarIdsReptils() {
        return reptilService.listarIds();
    }
}
