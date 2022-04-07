package spring.mvc.hibernate.dao;

import spring.mvc.hibernate.entity.Task;

import java.util.List;

public interface TaskDAO {
    Task getTask(int id);

    List<Task> getAllTasks();

    void saveTask(Task task);

    void deleteTask(int id);
}
