package CRM.CRM.service;

import CRM.CRM.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {

    void add(Task task);
    void update(Task task);
    void delete(Task task);
    Optional<Task> find(Long id);
    List<Task> findAll();
    Task findName(String name);
}
