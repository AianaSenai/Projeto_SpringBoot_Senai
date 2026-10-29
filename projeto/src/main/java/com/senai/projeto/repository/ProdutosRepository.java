package com.senai.projeto.repository;

import com.senai.projeto.entity.ProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutosRepository extends JpaRepository<ProdutosEntity, Long> {
    Optional<ProdutosEntity> findByNome(String nome);
}
