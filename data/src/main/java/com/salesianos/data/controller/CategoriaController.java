package com.salesianos.data.controller;

import com.salesianos.data.servicios.CategoriaService;
import com.salesianos.data.dto.EditCategoriaCmd;
import com.salesianos.data.dto.GetCategoriaDto;
import com.salesianos.data.models.Categoria;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria/")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<GetCategoriaDto> getAllCategorias() {
        return categoriaService.getCategorias()
                .stream().map(GetCategoriaDto::of)
                .toList();
    }

    @GetMapping("{id}")
    public Categoria getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoriaId(id);
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoriaService.createdCategoria(categoria));
    }

    @PutMapping("{id}")
    public Categoria edit(@RequestBody EditCategoriaCmd aEditar, @PathVariable Long id) {
        return categoriaService.editCategoria(aEditar,id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Categoria> delete(@PathVariable Long id) {
        categoriaService.deletedCategoria(id);
        return ResponseEntity.noContent().build();
    }


}
