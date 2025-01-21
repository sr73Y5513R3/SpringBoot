package com.salesianos.ejercicio03.repos;

import com.salesianos.ejercicio03.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
