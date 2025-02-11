package com.salesianos.pruebaSeguridad.repos;

import com.salesianos.pruebaSeguridad.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
