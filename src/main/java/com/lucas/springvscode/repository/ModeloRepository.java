package com.lucas.springvscode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.springvscode.model.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
