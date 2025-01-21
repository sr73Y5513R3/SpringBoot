package com.salesianos.ejemploProducto.models;

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
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @OneToMany (mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    public void addProducto(Producto producto) {
        producto.setCategoria(this);
        productos.add(producto);
    }

    public void removeProducto(Producto producto) {
        productos.remove(producto);
        producto.setCategoria(null);
    }
}
