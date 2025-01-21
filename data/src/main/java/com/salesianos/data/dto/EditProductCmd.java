package com.salesianos.data.dto;

public record EditProductCmd(
        String nombre,
        String descripcion,
        double precio,
        Long idCategoria
) {}
