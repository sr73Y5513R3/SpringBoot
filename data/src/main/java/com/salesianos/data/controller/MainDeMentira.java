package com.salesianos.data.controller;

import com.salesianos.data.models.Producto;
import com.salesianos.data.repos.ProductRepository;
import jakarta.annotation.PostConstruct;

public class MainDeMentira {

    private ProductRepository repo;

    @PostConstruct
    public void run(){
        Producto p = Producto.builder()
                .nombre("Un producto")
                .descripcion("Se trata de un producto de nuestro catálogo")
                .precioVenta(123.45)
                .build();

        repo.save(p);
        System.out.println(p);
    }
}
