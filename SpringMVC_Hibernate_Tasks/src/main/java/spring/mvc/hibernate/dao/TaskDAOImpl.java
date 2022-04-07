package spring.mvc.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.mvc.hibernate.entity.Task;

import java.util.List;

//Класс, который ответственнен за работу с базой данных (подключение и работа с данными)
//DAO - Data Access Object (изолированный посредник для работы с данными)
@Repository
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Task getTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        Task task = session.get(Task.class, id);
        return task;
    }

    @Override
//    @Transactional - убираем в сервис, чтобы запуск был в сервисе, а не в репозитории
    public List<Task> getAllTasks() {

        Session session = sessionFactory.getCurrentSession();
        List<Task> allTasks = session.createQuery("from Task", Task.class)
                .getResultList();

        return allTasks;
    }

    @Override
    public void saveTask(Task task) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(task);
    }

    @Override
    public void deleteTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Task> query = session.createQuery("delete from Task where id=:taskId");
        query.setParameter("taskId", id);
        query.executeUpdate();
        //Такой способ интуитивно проще, но из-за метода getTask мы еще раз общаемся с базой, что не очень эффективно
//        Task task = getTask(id);
//        session.delete(task);

    }
}
