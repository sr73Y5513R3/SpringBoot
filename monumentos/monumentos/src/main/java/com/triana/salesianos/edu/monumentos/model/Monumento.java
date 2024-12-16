package com.triana.salesianos.edu.monumentos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monumento {

    private Long id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String codigoPais;
    private String pais;
    private String ciudad;
    private double longitud;
    private double latitud;
}
