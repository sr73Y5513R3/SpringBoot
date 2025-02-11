package com.salesianos.herenciaEjemplo.models.MappedSuperclass;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@ToString
public class Producto extends BaseEntity{

    private String nombre;
    private String descripcion;
}
