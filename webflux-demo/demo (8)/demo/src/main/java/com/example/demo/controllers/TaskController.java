package com.example.demo.controllers;

import com.example.demo.models.Task;
import com.example.demo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Task> createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/{id}")
    public Mono<Task> getTask(@PathVariable Long id) {
        return taskRepository.findById(id);
    }

    @GetMapping
    public Flux<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PutMapping("/{id}")
    public Mono<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskRepository.findById(id)
                .map(foundTask -> {
                    foundTask.setTitle(task.getTitle());
                    foundTask.setDescription(task.getDescription());
                    foundTask.setStatus(task.getStatus());
                    foundTask.setDueDate(task.getDueDate());
                    return foundTask;
                })
                .flatMap(taskRepository::save);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTask(@PathVariable Long id) {
        return taskRepository.deleteById(id);
    }
}

