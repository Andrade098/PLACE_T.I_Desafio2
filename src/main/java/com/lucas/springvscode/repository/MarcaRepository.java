package com.lucas.springvscode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.springvscode.model.Marca;

public interface MarcaRepository extends JpaRepository <Marca, Long> {
}

