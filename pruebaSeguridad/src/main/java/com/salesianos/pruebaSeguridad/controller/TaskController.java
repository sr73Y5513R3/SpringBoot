package com.salesianos.pruebaSeguridad.controller;

import com.salesianos.pruebaSeguridad.model.Task;
import com.salesianos.pruebaSeguridad.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("")
    public List<Task> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id){
        return taskService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Task> save(@RequestBody Task task){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(taskService.save(task));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Task task){
        taskService.delete(task.getId());
        return ResponseEntity.noContent().build();
    }

}
