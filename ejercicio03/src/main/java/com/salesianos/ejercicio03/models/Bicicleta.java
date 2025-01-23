package com.salesianos.ejercicio03.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Bicicleta bicicleta = (Bicicleta) o;
        return getIdBicicleta() != null && Objects.equals(getIdBicicleta(), bicicleta.getIdBicicleta());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
