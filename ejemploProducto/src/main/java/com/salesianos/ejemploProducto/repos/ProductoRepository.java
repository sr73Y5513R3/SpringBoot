package com.salesianos.ejemploProducto.repos;

import com.salesianos.ejemploProducto.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
