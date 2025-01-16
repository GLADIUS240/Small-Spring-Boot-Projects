package com.gladius.todo.services;

import com.gladius.todo.model.Task;
import org.springframework.stereotype.Service;
import com.gladius.todo.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public void createTask(String task) {
        Task newTask = new Task();
        newTask.setTitle(task);
        newTask.setCompleted(false);
        taskRepository.save(newTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid task Id"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
