package com.salesianos.ejercicio03;

import com.salesianos.ejercicio03.models.Bicicleta;
import com.salesianos.ejercicio03.models.Estacion;
import com.salesianos.ejercicio03.models.Uso;
import com.salesianos.ejercicio03.models.Usuario;
import com.salesianos.ejercicio03.repos.BicicletaRepositorio;
import com.salesianos.ejercicio03.repos.EstacionRepositorio;
import com.salesianos.ejercicio03.repos.UsoRepositorio;
import com.salesianos.ejercicio03.repos.UsuarioRepositorio;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    @Autowired
    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private final BicicletaRepositorio bicicletaRepositorio;

    @Autowired
    private final UsoRepositorio usoRepositorio;

    @Autowired
    private final EstacionRepositorio estacionRepositorio;

    @PostConstruct
    public void run(){

        Usuario usuario1 = Usuario.builder()
                .nombre("Juan")
                .numTarjeta("20390219030")
                .pin("1234")
                .saldo(203.25)
                .build();


        System.out.println(usuario1);
        usuarioRepositorio.save(usuario1);

        Bicicleta bicicleta1 = Bicicleta.builder()
                .marca("Yamaha")
                .estado("Bueno")
                .modelo("YHR-X50R")
                .build();

        System.out.println(bicicleta1);
        bicicletaRepositorio.save(bicicleta1);

        Estacion estacion1 = Estacion.builder()
                .nombre("Estacion 1")
                .numero(123456789)
                .capacidad(20)
                .coordenadas("(37.3825° N, 6.0030° W)")
                .build();

        System.out.println(estacion1);
        estacionRepositorio.save(estacion1);

        Uso uso1 = Uso.builder()
                .usuario(usuario1)
                .bicicleta(bicicleta1)
                .fechaInicio("13/1/2025 10:30")
                .fechaFin("13/1/2025 11:11")
                .estacion(estacion1)
                .coste(6.34)
                .build();

        System.out.println(uso1);
        usoRepositorio.save(uso1);



    }


}
