package com.salesianos.data.servicios;

import com.salesianos.data.dto.EditCategoriaCmd;
import com.salesianos.data.models.Categoria;
import com.salesianos.data.repos.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria createdCategoria (Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria editCategoria(EditCategoriaCmd categoria, Long id) {
        return categoriaRepository.findById(id)
                .map(old -> {
                    old.setNombre(categoria.nombre());
                    return categoriaRepository.save(old);
                }).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado la categoria con el id:" + id));
    }

    public void deletedCategoria (Long id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria getCategoriaId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay categoria con ID: " + id));
    }
}
