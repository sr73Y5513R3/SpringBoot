package com.salesianos.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String Pais;

    @Column(name = "Comunidad")
    private String comunidadAutonoma;

    @OneToMany(mappedBy = "ciudad", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Calle> calles = new ArrayList<>();

    public void addCalle(Calle calle){
        calle.setCiudad(this);
        this.calles.add(calle);
    }

    public void removeCalle(Calle calle){
        this.calles.remove(calle);
        calle.setCiudad(null);
    }
}
