package com.salesianos.ejercicio03.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table (name = "bicicleta")
public class Bicicleta {

    @Id
    @GeneratedValue
    private Long idBicicleta;

    private String marca;
    private String modelo;
    private String estado;



    //Cuando se inica un uso hasta que ese uso no termina
    //La bicicleta no está en ninguna estación entonces estacion = null
    //Una vez se termine el uso, la bicicleta se seteará a la estación
    //Que ha acabado
}
