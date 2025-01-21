package com.salesianos.data.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "calle")
public class Calle {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String latitud;
    private String longitud;

    @ManyToOne
    @JoinColumn(name = "ciudad_id",
    foreignKey = @ForeignKey(name= "fk_calle_ciudad"))
    private Ciudad ciudad;

}
