package com.lucas.springvscode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.springvscode.model.Marca;
import com.lucas.springvscode.repository.MarcaRepository;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> findById(Long id) {
        return marcaRepository.findById(id);
    }

    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    public void deleteById(Long id) {
        marcaRepository.deleteById(id);
    }
}