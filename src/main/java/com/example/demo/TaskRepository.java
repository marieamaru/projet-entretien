package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TaskRepository {

    private final HashMap<Integer,Task> taskRep = new HashMap<>();

    public void add(Task task){
        Objects.requireNonNull(task);
        taskRep.put(task.getId(),task);
    }

    public void remove(int id){
        taskRep.remove(id);
    }

    public List<Task> getTaskRep() {
        return new ArrayList<>(taskRep.values());
    }

}
