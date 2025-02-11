package com.salesianos.pruebaSeguridad02.user.repos;

import com.salesianos.pruebaSeguridad02.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
