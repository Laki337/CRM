package CRM.CRM.service;

import CRM.CRM.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {

    Task createTaskDeportament(String title, String full_text, String localDateTimeStart, String localDateTimeEnd, String priority, Long departamentId, boolean active);
    Task createTaskUser(String title, String full_text, String localDateTimeStart, String localDateTimeEnd, String priority, boolean active, Long departamentId);

    void update(Task task);

    boolean deleteTask(final Long id);

    List<Task> findByPriorityAndUserId(String name, Long id);

    List<Task> findByPriorityAndDeportamentId(String name, Long id);

}

