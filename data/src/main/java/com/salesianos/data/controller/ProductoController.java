package com.salesianos.data.controller;

import com.salesianos.data.dto.EditProductCmd;
import com.salesianos.data.servicios.ProductoService;
import com.salesianos.data.models.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/id")
    public Producto findById(@RequestParam Long id) {
        return productoService.findById(id);
    }

    @GetMapping
    public ResponseEntity<Producto> created (EditProductCmd producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                productoService.save(producto)
        );
    }

    @DeleteMapping
    public ResponseEntity<Producto> deleted (@RequestParam Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
