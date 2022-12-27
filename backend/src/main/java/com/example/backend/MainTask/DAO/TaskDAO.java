package com.example.backend.MainTask.DAO;

import com.example.backend.MainTask.Repository.TaskRepository;
import com.example.backend.MainTask.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TaskDAO {
    private static int PEOPLE_COUTN;
    @Autowired
    private TaskRepository repository;
    public void save(Task task){
        task.setId(++PEOPLE_COUTN);
        repository.save(task);
    }
    public List<Task> index(){
        return repository.findAll();
    }
    public Task show(int id){
        ArrayList<Task> mas = new ArrayList<>();
        for(Task peoples : repository.findAll()){
            mas.add(peoples);
        }
        return mas.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }
    public void update(int id , Task updateTask){
        Task TaskToBeUpdate = show(id);
        TaskToBeUpdate.setTask(updateTask.getTask());
        repository.save(updateTask);
    }
    public void delete(int id) {
        ArrayList<Task> mas = new ArrayList<>();
        for(Task peoples : repository.findAll()){
            mas.add(peoples);
        }
        deleteAll();
        mas.removeIf(p->p.getId()==id);
        for(Task p : mas){
            repository.save(p);
        }
    }
    public void deleteAll(){
        repository.deleteAll();
    }
}
