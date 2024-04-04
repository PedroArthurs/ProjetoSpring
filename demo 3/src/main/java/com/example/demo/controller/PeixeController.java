package com.example.demo.controller;

import com.example.demo.model.Peixe;

import com.example.demo.service.PeixeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peixes")
public class PeixeController {

    @Autowired
    PeixeService peixeService;

    @GetMapping
    public List<Peixe> listarPeixes() {
        return peixeService.listarPeixes();
    }

    @PostMapping
    public Peixe criar(@Valid @RequestBody Peixe peixe) {
        return peixeService.criar(peixe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Peixe peixe) {
        if (peixeService.atualizar(id, peixe) == null) {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(peixe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if (peixeService.deletar(id)) {
            String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/qtd")
    public int qtdPeixes() {
        return peixeService.qtd();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Peixe> peixeOptional = peixeService.buscarPorId(id);
        if (peixeOptional.isPresent()) {
            Peixe peixe = peixeOptional.get();
            return ResponseEntity.ok(peixe);
        } else {
            String mensagem = "Peixe com o ID " + id + " não encontrado.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/ids")
    public List<Long> listarIdsPeixes() {
        return peixeService.listarIds();
    }


}
