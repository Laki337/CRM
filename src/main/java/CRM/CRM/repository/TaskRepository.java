package CRM.CRM.repository;

import CRM.CRM.model.Deportament;
import CRM.CRM.model.Task;
import CRM.CRM.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
     Task findByTitle(String name);
     List<Task> findByPriority(String priority);

}
