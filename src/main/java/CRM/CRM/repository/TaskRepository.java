package CRM.CRM.repository;

import CRM.CRM.model.Deportament;
import CRM.CRM.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
     Task findByTitle(String name);
}
