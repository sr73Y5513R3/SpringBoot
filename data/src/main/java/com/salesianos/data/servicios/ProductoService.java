package com.salesianos.data.servicios;

import com.salesianos.data.dto.EditProductCmd;
import com.salesianos.data.models.Producto;
import com.salesianos.data.repos.CategoriaRepository;
import com.salesianos.data.repos.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductRepository productRepository;
    private final CategoriaRepository categoriaRepository;

    public List<Producto> findAll(){

        List<Producto> result = productRepository.findAll();
        if(result.isEmpty())
            throw new EntityNotFoundException("No se encontró el producto");

        return result;
    }

    public Producto findById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado dicho producto con el id: " + id));
    }

    public Producto save (EditProductCmd nuevo){
        return productRepository.save(Producto.builder()
                        .nombre(nuevo.nombre())
                        .precioVenta(nuevo.precio())
                        .descripcion(nuevo.descripcion())
                        .categoria(categoriaRepository.getReferenceById(nuevo.idCategoria()))
                .build());
    }

    public Producto edit(EditProductCmd producto, Long id){
        return productRepository.findById(id)
                .map(old -> {
                    old.setNombre(producto.nombre());
                    old.setDescripcion(producto.descripcion());
                    old.setPrecioVenta(producto.precio());
                    old.setCategoria(categoriaRepository.getReferenceById(producto.idCategoria()));
                    return productRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el producto con el id:" + id));
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
