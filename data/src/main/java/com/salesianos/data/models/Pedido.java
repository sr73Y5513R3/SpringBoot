package com.salesianos.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name= "pedido")
public class Pedido {

    @Id
    @GeneratedValue
    private Long id;

    @Builder.Default
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private String cliente;


}
