package spring.mvc.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.mvc.hibernate.entity.Task;
import spring.mvc.hibernate.service.TaskService;

import java.util.List;

@Controller
public class MyController {

    //В контроллере создаем и вызываем объект DAO для извлечения данных из базы
    @Autowired
    private TaskService taskService;

    @RequestMapping("/")
    public String showAllTasks(Model model) {
        //Здесь извлекаем данные из базы
        List<Task> allTasks = taskService.getAllTasks();
        //Здесь кладем их в модель, чтобы потом выводить эти данные во view all-tasks
        model.addAttribute("allTasks", allTasks);
        return "all-tasks";
    }

    @RequestMapping("/addNewTask")
    public String addNewTask(Model model){
        //Для формы ввода нового дела - создаем новый объект и кладем его в модель
        Task task = new Task();
        model.addAttribute("task", task);
        return "task-info";
    }

    @RequestMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task){
        //Для сохранения дела сохраняем объект из модели с введенными данными
        taskService.saveTask(task);
        return "redirect:/";
    }

    @RequestMapping("/updateTask")
    public String updateTask(@RequestParam("taskId") int id, Model model){
        //Ищем в базе дело по его id (которое автоматически вносится в модель при нажатии на update) и добавляем его в модель
        Task task = taskService.getTask(id);
        model.addAttribute("task", task);
        return "task-info";
    }

    @RequestMapping("/deleteTask")
    public String deleteTask(@RequestParam("taskId") int id){
        //Удаляем дело из базы по id (которое автоматически вносится в модель при нажатии на delete) и возвращаемся на главную
        taskService.deleteTask(id);
        return "redirect:/";
    }
}
