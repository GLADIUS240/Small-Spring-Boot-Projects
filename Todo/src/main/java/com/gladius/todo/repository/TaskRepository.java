package com.gladius.todo.repository;

import com.gladius.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> id(Long id);
}
