package com.salesianos.ejemploProducto.services;

import com.salesianos.ejemploProducto.models.Producto;
import com.salesianos.ejemploProducto.repos.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServices {

    private final ProductoRepository productoRepository;

    public List<Producto> findAll (){
        List<Producto> result = productoRepository.findAll();

        if (result.isEmpty())
            throw new EntityNotFoundException("No hay productos");


        return result;
    }

    public Producto findById (Long id){
        return productoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado dicho producto con el id: " + id));
    }

    public Producto save (Producto producto){
        return productoRepository.save(producto.builder()
                        .nombre(producto.getNombre())
                        .pvp(producto.getPvp())
                        .categoria(producto.getCategoria())
                .build());
    }

    public Producto edit (Long id, Producto nuevo){
        return productoRepository.findById(id).
                map(old ->{
                    old.setNombre(nuevo.getNombre());
                    old.setPvp(nuevo.getPvp());
                    old.setCategoria(nuevo.getCategoria());
                    return productoRepository.save(old);
                }).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el producto con el id: " + id));


    }

    public void delete (Long id){
        productoRepository.deleteById(id);
    }

}
