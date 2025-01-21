package com.salesianos.data.dto;

import com.salesianos.data.models.Categoria;

public record GetCategoriaDto(
    Long id,
    String nombre
) {

    public static GetCategoriaDto of(Categoria categoria) {
        return new GetCategoriaDto(categoria.getId(), categoria.getNombre());
    }

    }


