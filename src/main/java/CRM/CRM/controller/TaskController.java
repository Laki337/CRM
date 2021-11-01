package CRM.CRM.controller;

import CRM.CRM.model.Task;
import CRM.CRM.model.User;
import CRM.CRM.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("")
	public String tasks(Model model) {
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		final User user = (User) auth.getPrincipal();
		
		model.addAttribute("hight", taskService.findByPriorityAndUserId("Очень срочно", user.getId()));
		model.addAttribute("medium", taskService.findByPriorityAndUserId("Средней срочности", user.getId()));
		model.addAttribute("easy", taskService.findByPriorityAndUserId("Не срочно", user.getId()));
		return "tasks";
	}
	
	
	@PostMapping("/createTaskDeportament")
	public String createTaskDeportament(@RequestParam(name = "username", required = false) String name,
										@RequestParam(name = "full_text", required = false) String full_text,
										@RequestParam(name = "localDateTimeStart", required = false) String localDateTimeStart,
										@RequestParam(name = "localDateTimeEnd", required = false) String localDateTimeEnd,
										@RequestParam(name = "deportamentId", required = false) Long deportamentId,
										@RequestParam(name = "priority", required = false) String priority) {
		taskService.createTaskDeportament(name, full_text, localDateTimeStart, localDateTimeEnd, priority, deportamentId, true);
		
		return "redirect:/table";
	}
	
	@PostMapping("/createTaskUser")
	public String createTaskUser(@RequestParam(name = "username", required = false) String name,
								 @RequestParam(name = "full_text", required = false) String full_text,
								 @RequestParam(name = "localDateTimeStart", required = false) String localDateTimeStart,
								 @RequestParam(name = "localDateTimeEnd", required = false) String localDateTimeEnd,
								 @RequestParam(name = "userId", required = false) Long userId,
								 @RequestParam(name = "priority", required = false) String priority) {
		taskService.createTaskUser(name, full_text, localDateTimeStart, localDateTimeEnd, priority, true, userId);
		
		return "redirect:/table";
	}
	
	@PostMapping("/deleteTask/{id}")
	public String deleteTask(Long id) {
		taskService.deleteTask(id);
		return "redirect:/table";
	}
	
	@PostMapping("/updateTaskUser")
	public void updateTaskUser(String name, String full_text, @ModelAttribute String localDateTimeStart, String localDateTimeEnd, Long user) {
		//Task task = taskService.findName(name);
	//	task.setFull_text(full_text);
	//	task.setDepartamentId(user);
	}
	
	@PostMapping("/updateTaskDeportament")
	public void updateTaskDeportament(String name, String full_text, String localDateTimeStart, String localDateTimeEnd, Long deportament) {
	//	Task task = taskService.findName(name);
	//	task.setFull_text(full_text);
	//	task.setDepartamentId(deportament);
	}

	
	@GetMapping("/deportament/{id}")
	public String takss(@PathVariable(value = "id") Long id, Model model) {
		List<Task> hight = taskService.findByPriorityAndDeportamentId("Очень срочно", id);
		List<Task> medium = taskService.findByPriorityAndDeportamentId("Средней срочности", id);
		List<Task> easy = taskService.findByPriorityAndDeportamentId("Не срочно", id);
		
		
		model.addAttribute("hight", hight);
		model.addAttribute("medium", medium);
		model.addAttribute("easy", easy);
		
		
		return "tasks";
	}
	
}