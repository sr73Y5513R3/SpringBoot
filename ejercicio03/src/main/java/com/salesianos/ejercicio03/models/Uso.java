package com.salesianos.ejercicio03.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Uso {

    @Id
    @GeneratedValue
    private Long idUso;

    private String fechaInicio;
    private String fechaFin;

    private double coste;

    @ManyToOne
    @JoinColumn(name = "usuario_id",
    foreignKey = @ForeignKey(name = "fk_usuario_uso"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "bicicleta_id",
    foreignKey = @ForeignKey(name = "fk_bicicleta_uso"))
    private Bicicleta bicicleta;

    @ManyToOne
    @JoinColumn(name = "estacion_id",
    foreignKey = @ForeignKey(name = "fk_estacion_uso"))
    private Estacion estacion;
}
