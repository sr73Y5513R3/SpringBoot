package com.salesianos.data.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name= "productos")
public class Producto {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    @Column(name = "precio")
    private double precioVenta;

    //@Column(length = 4000)
    @Column(columnDefinition = "text")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "categoria_id",
            foreignKey = @ForeignKey(name = "fk_producto_categoria"))
    private Categoria categoria;
}

