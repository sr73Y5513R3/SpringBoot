package com.salesianos.ejemploProducto.repos;

import com.salesianos.ejemploProducto.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
