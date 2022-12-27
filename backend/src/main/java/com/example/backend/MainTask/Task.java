package com.example.backend.MainTask;

public class Task {
    public Task(){}
    private int id;
    private String task;
    public Task(int id, String task){
        this.id = id;
        this.task = task;
    }
    public int getId(){
        return id;
    }
    public String getTask(){
        return task;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setTask(String task){
        this.task = task;
    }
    @Override
    public String toString(){
        return String.format(
                "Task[id=%s, task='%s']",
                 id, task);
    }
}
