package com.lucas.springvscode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucas.springvscode.model.Marca;
import com.lucas.springvscode.model.Modelo;
import com.lucas.springvscode.repository.MarcaRepository;
import com.lucas.springvscode.repository.ModeloRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringVscodeApplication {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringVscodeApplication.class, args);
    }

    @PostConstruct
    public void init() {
        Marca marca1 = new Marca();
        marca1.setNome("Honda");
        marca1.setCodigoDenatran("123456");
        marca1.setAtivo(true);

        Marca marca2 = new Marca();
        marca2.setNome("Toyota");
        marca2.setCodigoDenatran("654321");
        marca2.setAtivo(true);

        marcaRepository.save(marca1);
        marcaRepository.save(marca2);

        Modelo modelo1 = new Modelo();
        modelo1.setNome("HRV");
        modelo1.setAno(2022);
        modelo1.setAtivo(true);
        modelo1.setMarca(marca1);
        modelo1.setCodigoDenatran("12345");

        Modelo modelo2 = new Modelo();
        modelo2.setNome("Civic");
        modelo2.setAno(2023);
        modelo2.setAtivo(true);
        modelo2.setMarca(marca1);
        modelo2.setCodigoDenatran("54321");

        Modelo modelo3 = new Modelo();
        modelo3.setNome("Corolla");
        modelo3.setAno(2023);
        modelo3.setAtivo(true);
        modelo3.setMarca(marca2);
        modelo3.setCodigoDenatran("67890");

        Modelo modelo4 = new Modelo();
        modelo4.setNome("SW4");
        modelo4.setAno(2023);
        modelo4.setAtivo(true);
        modelo4.setMarca(marca2);
        modelo4.setCodigoDenatran("98765");

        modeloRepository.save(modelo1);
        modeloRepository.save(modelo2);
        modeloRepository.save(modelo3);
        modeloRepository.save(modelo4);
    }
}
