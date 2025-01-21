package com.salesianos.ejemploProducto.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "Producto")
public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @Column(name = "precio")
    private double pvp;

    @ManyToOne
    @JoinColumn(name = "categoria_id",
    foreignKey = @ForeignKey(name = "fk_producto_categoria"))
    private Categoria categoria;
}
