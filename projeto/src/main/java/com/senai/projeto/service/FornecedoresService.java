package com.senai.projeto.service;


import com.senai.projeto.entity.FornecedoresEntity;
import com.senai.projeto.repository.FornecedoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedoresService {

    private FornecedoresRepository repository;


    public FornecedoresService(FornecedoresRepository repository){
        this.repository = repository;
    }

    public List<FornecedoresEntity> listarTodos(){
        return repository.findAll();
    }

    public FornecedoresEntity salvarFornecedores(FornecedoresEntity fornecedores) {
        if (repository.findByRazaoSocial(fornecedores.getRazaoSocial()).isPresent()) {
            throw new IllegalArgumentException("Fornecedor já existe");
        }
        return repository.save(fornecedores);
    }


    public FornecedoresEntity atualizarFornecedores(Long id, FornecedoresEntity fornecedores){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Fornecedor não encontrado");
        }

        fornecedores.setId(id);
        return repository.save(fornecedores);
    }


    public void excluirFornecedores(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Fornecedor não encontrado");
        }
        repository.deleteById(id);
    }

































}