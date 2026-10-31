package com.projeto.senai.service;

import com.projeto.senai.entity.PetsEntity;
import com.projeto.senai.repository.PetsRepositorios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsService {

    private final PetsRepositorios repository;

    public PetsService(PetsRepositorios repository) {
        this.repository = repository;
    }

    public List<PetsRepositorios> listarTodos() {
        return repository.findAll();
    }

    public PetsEntity salvarPets(PetsEntity pets) {
        if (repository.findByNome(pets.getNome()).isPresent()) {
            throw new IllegalArgumentException(
                    "Esse cadastro de pet já existe"
            );
        }

        return repository.save(pets);
    }

    public PetsEntity atualizarPet(Long id, PetsEntity pets) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Pet não encontrado.");
        }

        pets.setId(id);
        return repository.save(pets);
    }

    public void excluirPets(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Pet não encontrado.");
        }

        repository.deleteById(id);
    }
}