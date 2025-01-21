package com.salesianos.ejercicio03.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Estacion {

    @Id
    @GeneratedValue
    private Long idEstacion;

    private String nombre;
    private double numero;
    private String coordenadas;
    private double capacidad;
}
