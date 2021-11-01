package CRM.CRM.service;

import CRM.CRM.model.Event;
import CRM.CRM.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	EventRepository eventRepository;
	
	@Override
	public Event createEvent(String name, Long userId, Date dateStart, Date dateEnd, String type) {
	
	    Event event = new Event(name,userId,dateStart.toString(),dateEnd.toString(),type);
	    
		return eventRepository.save(event);
	}
	
	
	
	public List<Event> findByAllDateStartBetween(String dateStart, String dateEnd, Long id){

		return eventRepository.findByDateStartBetweenAndUserId(dateStart, dateEnd, id);
	}
}
