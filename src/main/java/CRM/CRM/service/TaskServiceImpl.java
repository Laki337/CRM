package CRM.CRM.service;

import CRM.CRM.model.Task;
import CRM.CRM.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    public void add(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void delete(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public Optional<Task> find(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findAll() {
       List<Task> list = taskRepository.findAll();
       return new ArrayList<>();
       }
    public Task findName(String name){
        return taskRepository.findByTitle(name);
    }
}
