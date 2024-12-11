package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/")
@RequiredArgsConstructor
public class ProductoController {

    //Primera forma de hacerlo
    //@Autowired
    //private ProductoRespositorio productoRespositorio;

    //Forma optima
    //Le metemos @RequiredArgsContructor
    private final ProductoRespositorio productoRespositorio;

    //Segunda forma de hacerlo
   /* public ProductoController(ProductoRespositorio productoRespositorio) {
        this.productoRespositorio = productoRespositorio;
    }*/

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
      /*
      * 1. Obtener del repositorio la lista de productos
      * 2. Si la lista está vacia, devolver 404
      * 3. Si la lista tiene productos, devolver 200 con la lista
      * */

        List<Product> result = productoRespositorio.getAll();

        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);

    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoRespositorio.add(product));
    }

}