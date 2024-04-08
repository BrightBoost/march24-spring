package com.example.demo.repositories;

import com.example.demo.models.Task;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TaskRepository extends ReactiveCrudRepository<Task, Long> {
}
