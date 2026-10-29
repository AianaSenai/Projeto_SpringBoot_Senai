package com.senai.projeto.repository;

import com.senai.projeto.entity.FornecedoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FornecedoresRepository extends JpaRepository<FornecedoresEntity,Long> {
    Optional<Object> findByRazaoSocial(String razaoSocial);
}
