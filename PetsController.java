package com.projeto.senai.controller;

import com.projeto.senai.entity.PetsEntity;
import com.projeto.senai.repository.PetsRepositorios;
import com.projeto.senai.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Pets")
public class PetsController {

    @Autowired
    private PetsService service;

    @GetMapping
    public List<PetsRepositorios> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(
            @RequestBody PetsEntity pets) {

        service.salvarPets(pets);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Pet cadastrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody PetsEntity pets) {

        service.atualizarPet(id, pets);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Pet atualizado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(
            @PathVariable Long id) {

        service.excluirPets(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Pet excluído"));
    }
}
