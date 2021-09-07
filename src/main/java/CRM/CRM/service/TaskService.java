package CRM.CRM.service;

import CRM.CRM.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {

    String add(Task task);
    void update(Task task);
    String delete(Task task);
    Optional<Task> find(Long id);
    List<List<Task>> findTaskPriority(Long id);
    List<Task> findAll();
    Task findName(String name);



}
