package spring.mvc.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc.hibernate.dao.TaskDAO;
import spring.mvc.hibernate.entity.Task;

import java.util.List;


//Класс, содержащий бизнес-логику, соединительное звено между контроллером и DAO
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDAO taskDAO;

    @Override
    @Transactional
    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }

    @Override
    @Transactional
    public void saveTask(Task task) {
        taskDAO.saveTask(task);
    }

    @Override
    @Transactional
    public Task getTask(int id) {
        return taskDAO.getTask(id);
    }

    @Override
    @Transactional
    public void deleteTask(int id) {
        taskDAO.deleteTask(id);
    }
}
