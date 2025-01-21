package com.salesianos.ejercicio03.repos;

import com.salesianos.ejercicio03.models.Bicicleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicicletaRepositorio extends JpaRepository<Bicicleta, Long> {
}
