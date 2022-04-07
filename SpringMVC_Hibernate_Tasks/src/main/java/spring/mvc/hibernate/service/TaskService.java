package spring.mvc.hibernate.service;

import spring.mvc.hibernate.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    void saveTask(Task task);

    Task getTask(int id);

    void deleteTask(int id);
}
