package com.lucas.springvscode.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.springvscode.model.Modelo;
import com.lucas.springvscode.service.ModeloService;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {
    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public List<Modelo> getAll() {
        return modeloService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> getById(@PathVariable Long id) {
        Optional<Modelo> modelo = modeloService.findById(id);
        return modelo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Modelo> create(@RequestBody Modelo modelo) {
        Modelo savedModelo = modeloService.save(modelo);
        return ResponseEntity.ok(savedModelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> update(@PathVariable Long id, @RequestBody Modelo modelo) {
        if (!modeloService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        modelo.setId(id);
        Modelo updatedModelo = modeloService.save(modelo);
        return ResponseEntity.ok(updatedModelo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!modeloService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        modeloService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
