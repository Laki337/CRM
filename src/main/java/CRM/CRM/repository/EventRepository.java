package CRM.CRM.repository;

import CRM.CRM.model.Event;
import CRM.CRM.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
	List<Event> findByUserIdAndDateStart(String name, Long id);
	List<Event> findByDateStartBetweenAndUserId(String dateStart, String dateEnd, Long id);
}
