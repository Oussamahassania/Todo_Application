package com.app.todoapp.controller;


import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    private String getTasks(Model model) {
        List<Task>tasks=taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
    @PostMapping("/create")
    private String createTask(
            @RequestParam String title
    ){
        taskService.createTask(title);
        return "redirect:/tasks";
    }
    @GetMapping("/{id}/delete")
    private String deleteTask( @PathVariable  Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
    @GetMapping("/{id}/toggle")
    private String toggleTask( @PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/tasks";
    }
}
