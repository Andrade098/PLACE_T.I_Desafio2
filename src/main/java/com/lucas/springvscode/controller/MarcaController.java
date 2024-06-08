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

import com.lucas.springvscode.model.Marca;
import com.lucas.springvscode.service.MarcaService;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<Marca> getAll() {
        return marcaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> getById(@PathVariable Long id) {
        Optional<Marca> marca = marcaService.findById(id);
        return marca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        
    }

    @PostMapping
    public Marca create(@RequestBody Marca marca) {
        return marcaService.save(marca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> update(@PathVariable Long id, @RequestBody Marca marca) {
        if (!marcaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        marca.setId(id);
        return ResponseEntity.ok(marcaService.save(marca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!marcaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        marcaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
