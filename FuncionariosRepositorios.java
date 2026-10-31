package com.projeto.senai.repository;

import com.projeto.senai.entity.FuncionariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionariosRepositorios  extends JpaRepository<FuncionariosEntity, Long> {
    Optional<Object> findByNome(String nome);
}
