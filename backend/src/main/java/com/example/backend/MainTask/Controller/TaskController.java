package com.example.backend.MainTask.Controller;

import com.example.backend.MainTask.DAO.TaskDAO;
import com.example.backend.MainTask.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskDAO taskDAO;
    @Autowired
    public TaskController(TaskDAO taskDAO){
        this.taskDAO = taskDAO;
    }

      @GetMapping()
      public String index(Model model){
        model.addAttribute("task", taskDAO.index());
          return "Task/TaskList";
      }
      @GetMapping("/{id}")
      public String show(@PathVariable("id") int id,Model model ){
        model.addAttribute("show", taskDAO.show(id));
          return "Task/show";
      }
      @ModelAttribute("headerMessage")
    public String populateLate(){
        return "Welcome to my house";
      }
      @GetMapping("/new")
      public String newTask(Model model){
        model.addAttribute("task",new Task());
        return "Task/new";
      }
      @PostMapping
      public String createTask(@ModelAttribute("task") Task task){
        taskDAO.save(task);
        return "redirect:/task";
      }
      @GetMapping("/{id}/edit")
    public String editTask(Model model,@PathVariable("id") int id){
        model.addAttribute("task", taskDAO.show(id));
        return "Task/edit";
      }
      @PatchMapping("/{id}")
    public String update(@ModelAttribute("task") Task task, @PathVariable("id") int id){
//        personDAO.save(people);
        taskDAO.update(id,task);
        return "redirect:/task";
      }
      @DeleteMapping("/{id}")
    public String delete(@PathVariable("id" )int id){
        taskDAO.delete(id);
        return "redirect:/task";
      }
}
