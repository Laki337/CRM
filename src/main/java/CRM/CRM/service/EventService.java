package CRM.CRM.service;

import CRM.CRM.model.Event;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface EventService {

    Event createEvent(String name, Long userId, Date dateStart, Date dateEnd, String type);
    
	
	List<Event> findByAllDateStartBetween(String dateStart,String dateEnd, Long id);
	

}
