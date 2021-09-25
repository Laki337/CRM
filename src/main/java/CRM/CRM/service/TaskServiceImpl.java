package CRM.CRM.service;

import CRM.CRM.CrmApplication;
import CRM.CRM.controller.DeportamentController;
import CRM.CRM.model.Task;
import CRM.CRM.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserService userService;

    @Override
    public String add(Task task) {

        taskRepository.save(task);
        return "Создание задачи прошло успешно";
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public String delete(Task task) {

            taskRepository.delete(task);
        CrmApplication.LOGGER.info("Задача удалена успешно");
        return "Задача удалена успешно";
    }

    @Override
    public Optional<Task> find(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findAll() {
        List<Task> list = taskRepository.findAll();
        return list;
    }

    public Task findName(String name) {
        return taskRepository.findByTitle(name);
    }

    @Override
    public List<Task> findByPriority(String priority) {
        return taskRepository.findByPriority(priority);
    }


    public List<List<Task>> findTaskPriority(Long id) {
        List<List<Task>> l = new ArrayList<>();
        List<Task> list = taskRepository.findAll();
        List<Task> easy = new ArrayList<>();
        List<Task> medium = new ArrayList<>();
        List<Task> hight = new ArrayList<>();
        for (Task t : list) {
            if (t.getUserId() != id) {
                System.out.println("RAZ");
                continue;
            }
            if (t.getPriority().equals("easy")) {
                easy.add(t);
            }
            if (t.getPriority().equals("medium")) {
                medium.add(t);
            }
            if (t.getPriority().equals("hight")) {
                hight.add(t);
            }
        }
        l.add(easy);
        l.add(medium);
        l.add(hight);
        System.out.println(l);
        return l;
    }

}
