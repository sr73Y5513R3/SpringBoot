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

    @OneToMany(mappedBy = "bicicleta", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Uso> usoBicicleta = new ArrayList<Uso>();

    public void addUsoBicicleta (Uso uso) {
        uso.setBicicleta(this);
        usoBicicleta.add(uso);
    }

    public void removeUsoBicicleta (Uso uso) {
        usoBicicleta.remove(uso);
        uso.setBicicleta(null);
    }

    //Cuando se inica un uso hasta que ese uso no termina
    //La bicicleta no está en ninguna estación entonces estacion = null
    //Una vez se termine el uso, la bicicleta se seteará a la estación
    //Que ha acabado
}
