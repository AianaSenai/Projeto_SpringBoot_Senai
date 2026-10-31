package com.projeto.senai.repository;

import com.projeto.senai.entity.ServicosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServicosRepositorios
        extends JpaRepository<ServicosEntity, Long> {

    Optional<ServicosEntity> findByNome(String nome);
}
