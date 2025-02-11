package com.salesianos.pruebaSeguridad.service;

import com.salesianos.pruebaSeguridad.model.Task;
import com.salesianos.pruebaSeguridad.repos.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> findAll (){
        return taskRepository.findAll();
    }

    public Task findById (Long id){
        Optional<Task> result = taskRepository.findById(id);

        if(result.isEmpty())
            throw new EntityNotFoundException("No se encontro un task con ese id: "+id);


        return result.get();
    }

    public Task save (Task task){
        return taskRepository.save(task);
    }

    public void delete (Long id){
        taskRepository.deleteById(id);
    }

}
