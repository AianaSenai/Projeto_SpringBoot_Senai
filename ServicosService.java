package com.projeto.senai.service;

import com.projeto.senai.entity.ServicosEntity;
import com.projeto.senai.repository.ServicosRepositorios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicosService {

    private final ServicosRepositorios repository;

    public ServicosService(ServicosRepositorios repository) {
        this.repository = repository;
    }

    public List<ServicosEntity> listarTodos() {
        return repository.findAll();
    }

    public ServicosEntity salvarServicos(ServicosEntity servicos) {
        if (repository.findByNome(servicos.getNome()).isPresent()) {
            throw new IllegalArgumentException(
                    "Esse serviço já está cadastrado"
            );
        }

        return repository.save(servicos);
    }

    public ServicosEntity atualizarServico(Long id, ServicosEntity servicos) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Serviço não encontrado.");
        }

        servicos.setId(id);
        return repository.save(servicos);
    }

    public void excluirServico(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Serviço não encontrado.");
        }

        repository.deleteById(id);
    }
}
