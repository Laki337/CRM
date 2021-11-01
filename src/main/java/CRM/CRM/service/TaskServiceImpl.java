package CRM.CRM.service;


import CRM.CRM.model.Task;
import CRM.CRM.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	Logger logger;
	
	@Override
	public Task createTaskUser(String title, String full_text, String localDateTimeStart, String localDateTimeEnd, String priority, boolean active, Long userId) {
		
		return createTask(Task_from.USER, title, full_text, localDateTimeStart, localDateTimeEnd, priority, userId, active);
	}
	
	@Override
	public Task createTaskDeportament(String title, String full_text, String localDateTimeStart, String localDateTimeEnd, String priority, Long departamentId, boolean active) {
		return createTask(Task_from.DEP, title, full_text, localDateTimeStart, localDateTimeEnd, priority, departamentId, active);
	}
	
	public Task createTask(Task_from from, String title, String full_text, String localDateTimeStart, String localDateTimeEnd, String priority, Long id, boolean active) {
		
		final Task task;
		try {
			switch(from) {
				case USER:
					task = new Task(title, full_text, localDateTimeStart, localDateTimeEnd, priority, active, id);
					break;
				case DEP:
					task = new Task(title, full_text, localDateTimeStart, localDateTimeEnd, priority, id, active);
					break;
				default:
					throw new IllegalStateException("Unexpected value: " + from);
			}
			taskRepository.save(task);
			logger.info("Задача создана");
		} catch(Exception ex) {
			logger.info("Задача не создана");
			return null;
		}
		
		return task;
	}
	
	@Override
	public void update(Task task) {
	
	}
	
	public boolean deleteTask(final Long id) {
		final Task task;
		try {
			task = taskRepository.findById(id).get();
			
			if(task == null) {
				logger.info("Такой пользователь не существует");
				return false;
			}
			logger.info("Пользователь успешно удалён");
			taskRepository.delete(task);
		} catch(Exception e) {
			logger.info("Пользователь не удалён");
			return false;
		}
		return true;
	}
	
	@Override
	public List<Task> findByPriorityAndDeportamentId(String name, Long id) {
		
		return taskRepository.findByPriorityAndDepartamentId(name, id);
	}
	
	@Override
	public List<Task> findByPriorityAndUserId(String name, Long id) {
		
		return taskRepository.findByPriorityAndUserId(name, id);
	}
	
	
}

enum Task_from {
	USER, DEP
}