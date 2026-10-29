package com.senai.projeto.controller;


import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.entity.FornecedoresEntity;
import com.senai.projeto.service.FornecedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedores")
public class FuncionarioController {


    @Autowired
    private FornecedoresService service;

    @GetMapping
    public List<FornecedoresEntity> listar(){
        return service.listarTodos();
    }


    @PostMapping
    ResponseEntity<Map<?,?>> salvar(@RequestBody FornecedoresEntity fornecedores) {
        service.salvarFornecedores(fornecedores);
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Fornecedor cadastrado com sucesso"));

    }


    @PutMapping("/{id}")
    ResponseEntity<Map<?,?>>atualizar(
            @PathVariable Long id,
            @RequestBody FornecedoresEntity fornecedores){

        service.atualizarFornecedores(id,fornecedores);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Fornecedor atualizado com sucesso!"));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<?,?>>excluir(@PathVariable Long id){

        service.excluirFornecedores(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Fornecedor excluido com sucesso!"));
    }

}


