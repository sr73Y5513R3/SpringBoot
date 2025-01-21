package com.salesianos.ejercicio03.repos;

import com.salesianos.ejercicio03.models.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionRepositorio extends JpaRepository<Estacion, Long> {
}
