package com.salesianos.ejemploProducto.services;

import com.salesianos.ejemploProducto.models.Categoria;
import com.salesianos.ejemploProducto.repos.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAll (){
        List<Categoria> categorias = categoriaRepository.findAll();

        if (categorias.isEmpty()) {
            throw new EntityNotFoundException("No se ha encontrado ninguna categoria");
        }

        return categorias;
    }

    public Categoria findById (Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado ninguna categoria con el id: "+ id));
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria.builder()
                        .nombre(categoria.getNombre())
                .build());
    }

    public Categoria edit (Long id, Categoria categoria) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(categoria.getNombre());
                    return categoriaRepository.save(old);
                }).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado ninguna categoria con el id: "+ id));
    }

    public void delete (Long id){
        categoriaRepository.deleteById(id);
    }
}
