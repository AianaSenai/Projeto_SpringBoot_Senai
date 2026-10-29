package com.senai.projeto.controller;

import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.entity.ProdutosEntity;
import com.senai.projeto.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosService service;

    @GetMapping
    public List<ProdutosEntity> listar(){
        return service.listarTodos();
    }

    @PostMapping
    ResponseEntity<Map<?,?>> salvar(@RequestBody ProdutosEntity produtos) {
        service.salvarProdutos(produtos);
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Produto cadastrado com sucesso"));

    }

    @PutMapping("/{id}")
    ResponseEntity<Map<?,?>>atualizar(
            @PathVariable Long id,
            @RequestBody ProdutosEntity produtos){

        service.atualizarProdutos(id,produtos);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Produto atualizado com sucesso!"));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Map<?,?>>excluir(@PathVariable Long id){

        service.excluirProduto(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Produto excluido com sucesso!"));
    }

}


