package com.salesianos.asociacionesParejas.repos;

import com.salesianos.asociacionesParejas.models.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
}
