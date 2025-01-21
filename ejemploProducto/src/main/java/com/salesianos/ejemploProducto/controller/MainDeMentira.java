package com.salesianos.ejemploProducto.controller;

import com.salesianos.ejemploProducto.models.Producto;
import com.salesianos.ejemploProducto.services.CategoriaService;
import com.salesianos.ejemploProducto.services.ProductoServices;
import jakarta.annotation.PostConstruct;

public class MainDeMentira {

    private ProductoServices productoServices;
    private CategoriaService categoriaService;

    @PostConstruct
    public void run(){
        Producto p = new Producto().builder()
                .nombre("Cerveza")
                .pvp(1.2)
                .categoria(categoriaService.findById(1L))
                .build();

        productoServices.save(p);
    }
}
