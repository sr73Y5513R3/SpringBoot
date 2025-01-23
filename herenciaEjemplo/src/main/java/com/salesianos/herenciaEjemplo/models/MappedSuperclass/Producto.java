package com.salesianos.herenciaEjemplo.models.MappedSuperclass;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Producto extends BaseEntity{

    private String nombre;
    private String descripcion;
}
