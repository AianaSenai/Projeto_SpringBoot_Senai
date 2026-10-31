package com.projeto.senai.service;

import com.projeto.senai.entity.FuncionariosEntity;
import com.projeto.senai.repository.FuncionariosRepositorios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosService {
    private FuncionariosRepositorios repository;

    public FuncionariosService(FuncionariosRepositorios repository) {
        this.repository = repository;
    }

    public List<FuncionariosEntity> listarTodos() {
        return repository.findAll();
    }

    public FuncionariosEntity salvarFuncionarios(FuncionariosEntity funcionarios) {
        if (repository.findByNome(funcionarios.getNome()).isPresent()) {

            throw new IllegalArgumentException("Esse cadastro de Funcionario ja existe");
        }
        return repository.save(funcionarios);
    }
    public FuncionariosEntity atualizarFuncionario(Long id, FuncionariosEntity funcionarios){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Funcionarios nao encontrado.");
        }
        funcionarios.setId(id);
        return repository.save(funcionarios);
    }

    public void excluirFuncionarios(Long id){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Funcionario nao encontrado");
        }
        repository.deleteById(id);
    }
}