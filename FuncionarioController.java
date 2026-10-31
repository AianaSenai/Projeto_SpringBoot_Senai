package com.projeto.senai.controller;

import com.projeto.senai.entity.FuncionariosEntity;
import com.projeto.senai.service.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Funcionarios")

public class FuncionarioController {

    @Autowired
    private FuncionariosService service;

    @GetMapping
    public List<FuncionariosEntity> Listar() {
        return service.listarTodos();
    }

    @PostMapping
    ResponseEntity<Map<?, ?>> salvar(@RequestBody FuncionariosEntity funcionarios) {
        service.salvarFuncionarios(funcionarios);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Funcionarios cadastrado"));

    }

    @PutMapping("/{id}")
    ResponseEntity<Map<?, ?>> atualizar(
            @PathVariable Long id,
            @RequestBody FuncionariosEntity funcionarios) {
        service.atualizarFuncionario(id, funcionarios);
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionario atualizado"));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<? ,?>>excluir(@PathVariable Long id){
        service.excluirFuncionarios(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionario excluido"));
    }
}
