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

import java.util.ArrayList;
import java.util.List;

@Controller

public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("")
    public String getTask() {
        return "task";
    }

    @GetMapping("/tasks")
    public String tasks(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        List<List<Task>> task = taskService.findTaskPriority(user.getId());
        List<Task> tasks = new ArrayList<>();
        System.out.println(task);
        model.addAttribute("easy", task.get(0));
        model.addAttribute("medium", task.get(1));
        model.addAttribute("hight", task.get(2));
        return "tasks";
    }

    @GetMapping("/AllTask")
    public String allTask(Model model) {
        Iterable<Task> task = taskService.findAll();
        System.err.println(task.toString());
        model.addAttribute("task", task);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        System.out.println(user);
        return "AllTask";
    }



    @PostMapping("/createTaskUser")
    public String createTaskUser(@RequestParam(name = "username", required = false) String name,
                                 @RequestParam(name = "full_text" , required = false)  String full_text,
                                 @RequestParam(name = "localDateTimeStart" , required = false)String localDateTimeStart,
                                 @RequestParam(name = "localDateTimeEnd" , required = false)String localDateTimeEnd,
                                 @RequestParam(name = "deportament" , required = false)Long deportament,
                                 @RequestParam(name = "user" , required = false)Long user,
                                 @RequestParam(name = "priority" , required = false)  String priority) {
        Task task = new Task(name, full_text, localDateTimeStart, localDateTimeEnd,priority, 3L, true);
        System.err.println("TASK");
        taskService.add(task);

        return "CreateTask";
    }
    @PostMapping("/createTaskDeportament")
    public String createTaskDeportament(@RequestParam(name = "username", required = false) String name,
                                 @RequestParam(name = "full_text" , required = false)  String full_text,
                                 @RequestParam(name = "localDateTimeStart" , required = false)String localDateTimeStart,
                                 @RequestParam(name = "localDateTimeEnd" , required = false)String localDateTimeEnd,
                                 @RequestParam(name = "deportamentId" , required = false)Long deportamentId,
                                 @RequestParam(name = "priority" , required = false)  String priority
                                        ) {
        System.out.println(deportamentId);
        Task task = new Task(name, full_text, localDateTimeStart, localDateTimeEnd,priority ,5L, 3L, true);
        System.out.println(deportamentId);
        System.err.println("TASK");
        taskService.add(task);

        return "redirect:/table";
    }

    @PostMapping("/deleteTask")
    public String deleteTask(String name) {
        Task task = taskService.findName(name);
        taskService.delete(task);
        return "deleteTask";
    }

    @PostMapping("/updateTaskUser")
    public void updateTaskUser(String name, String full_text, @ModelAttribute String localDateTimeStart, String localDateTimeEnd, Long user) {
        Task task = taskService.findName(name);
        task.setFull_text(full_text);
        //  task.setLocalDateTimeStart(localDateTimeStart);
        //  task.setLocalDateTimeEnd(localDateTimeEnd);
        task.setDepartamentId(user);
    }

    @PostMapping("/updateTaskDeportament")
    public void updateTaskDeportament(String name, String full_text, String localDateTimeStart, String localDateTimeEnd, Long deportament) {
        Task task = taskService.findName(name);
        task.setFull_text(full_text);
        //   task.setLocalDateTimeStart(localDateTimeStart);
        //       task.setLocalDateTimeEnd(localDateTimeEnd);
        task.setDepartamentId(deportament);
    }


    @GetMapping("/taskDeportament/{id}")
    public String tasks(@PathVariable(value = "id") Long id, Model model) {
        System.out.println("Olalal");
        List<Task> tasks = taskService.findAll();
        for (Task task : tasks) {
            if (task.getDepartamentId() != id) {
                tasks.remove(task);
            }
        }
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/taskUser/{id}")
    public String tasksUser(@PathVariable(value = "id") Long id, Model model) {
        System.out.println("Olalal");
        List<Task> tasks = taskService.findAll();
        for (Task task : tasks) {
            if (task.getUserId() != id) {
                tasks.remove(task);
            }
        }
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String takss(@PathVariable(value = "id") Long id,Model model){
        List<Task> tasks = taskService.findAll();
        for(Task task: tasks){
            if (task.getDepartamentId()!= id){
                tasks.remove(task);
            }
        }
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

}