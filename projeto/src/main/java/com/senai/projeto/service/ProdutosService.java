package com.senai.projeto.service;


import com.senai.projeto.entity.ClienteEntity;
import com.senai.projeto.entity.ProdutosEntity;
import com.senai.projeto.repository.ProdutosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosService {

    private ProdutosRepository repository;

    public ProdutosService(ProdutosRepository repository) {

        this.repository = repository;
    }

    public List<ProdutosEntity> listarTodos(){

        return repository.findAll();
    }

    public ProdutosEntity salvarProdutos(ProdutosEntity produtos){
        if(repository.findByNome(produtos.getNome()).isPresent()){
            throw new IllegalArgumentException("Produto já cadastrado");
        }
        return repository.save(produtos);
    }

    public ProdutosEntity atualizarProdutos(Long id, ProdutosEntity produtos){
        if(!repository.existsById(id))
            throw new IllegalArgumentException("Produto não encontrado");

        produtos.setId(id);
        return repository.save(produtos);
    }


    public void excluirProduto(Long id){
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Produto não encontrado");

        repository.deleteById(id);
    }

}



