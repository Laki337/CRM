package CRM.CRM.controller;

import CRM.CRM.model.Task;
import CRM.CRM.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("")
    public String getTask(){
        return "Task";
    }





    @PostMapping("/createTaskDeportament")
    public String createTaskDeportament(String name, String full_text, Date localDateTimeStart,  Long deportamentId, Date localDateTimeEnd){
        Task task = new Task(name,full_text,localDateTimeStart,deportamentId,localDateTimeEnd);
        taskService.add(task);
        return "createTaskDeportament";
    }
    @PostMapping("/createTaskUser")
    public String createTaskUser(String name,String full_text, Date localDateTimeStart, Date localDateTimeEnd, long user){
        Task task = new Task(name,full_text,localDateTimeStart,user,localDateTimeEnd);
        taskService.add(task);
        return "CreateTask";
    }

   @PostMapping("/deleteTask")
    public String deleteTask(String name){
        Task task = taskService.findName(name);
        taskService.delete(task);
        return "deleteTask";
   }
   @PostMapping("/updateTaskUser")
    public void updateTaskUser(String name,String full_text, LocalDateTime localDateTimeStart, LocalDateTime localDateTimeEnd, Long user){
       Task task = taskService.findName(name);
       task.setFull_text(full_text);
     //  task.setLocalDateTimeStart(localDateTimeStart);
     //  task.setLocalDateTimeEnd(localDateTimeEnd);
       task.setDepartamentId(user);
   }

    @PostMapping("/updateTaskDeportament")
    public void updateTaskDeportament(String name,String full_text, LocalDateTime localDateTimeStart, LocalDateTime localDateTimeEnd, Long deportament){
        Task task = taskService.findName(name);
        task.setFull_text(full_text);
     //   task.setLocalDateTimeStart(localDateTimeStart);
 //       task.setLocalDateTimeEnd(localDateTimeEnd);
        task.setDepartamentId(deportament);
    }


}