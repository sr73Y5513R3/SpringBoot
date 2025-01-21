package com.salesianos.ejercicio03.models;


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
@Table (name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue
    private Long idUsuario;

    private String nombre;

    @Column(name = "tarjeta")
    private String numTarjeta;

    @Column(length = 4)
    private String pin;

    private double saldo;

    @OneToMany (mappedBy = "usuario", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Uso> usosUsuario = new ArrayList<Uso>();

    public void addUso (Uso uso) {
        uso.setUsuario(this);
        usosUsuario.add(uso);
    }

    public void removeUso (Uso uso) {
        usosUsuario.remove(uso);
        uso.setUsuario(null);
    }


}
