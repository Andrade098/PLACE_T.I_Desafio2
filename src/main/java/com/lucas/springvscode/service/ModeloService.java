package com.lucas.springvscode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.springvscode.model.Modelo;
import com.lucas.springvscode.repository.ModeloRepository;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;

    public List<Modelo> findAll() {
        return modeloRepository.findAll();
    }

    public Optional<Modelo> findById(Long id) {
        return modeloRepository.findById(id);
    }

    public Modelo save(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public void deleteById(Long id) {
        modeloRepository.deleteById(id);
    }
}
