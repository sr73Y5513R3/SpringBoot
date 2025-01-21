package com.salesianos.data.models;

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
@Table(name= "categoria")
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;



    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Producto> productos = new ArrayList<Producto>();

    /*
    @OneToMany(mappedBy = "categoriaPadre", fetch = FetchType.EAGER)
    @Builder.Default
    @ToString.Exclude
    private List<Categoria> subcategorias = new ArrayList<Categoria>();

    @ManyToOne
    @JoinColumn(name = "categoria_relacion_id",
            foreignKey = @ForeignKey(name = "fk_categoria_padre_subcategorias"))
    private Categoria categoriaPadre;
    */

    public void addProducto(Producto producto) {
        producto.setCategoria(this);
        this.getProductos().add(producto);
    }

    public void removeProducto(Producto producto) {
        this.getProductos().remove(producto);
        producto.setCategoria(null);
    }

    /*

    public void addSubcategoria(Categoria categoria) {
        categoria.setCategoriaPadre(this);
        this.getSubcategorias().add(categoria);
    }

    public void removeSubcategoria(Categoria categoria) {
        this.getSubcategorias().remove(categoria);
        categoria.setCategoriaPadre(null);
    }

    */

}
