package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/task/list")
    public Collection<Task> taskList() {
        return taskRepository.getTaskRep();
    }

    @PostMapping("/task/add")
    public Collection<Task> addToRep(@RequestBody JSON json) {
        Type temp= json.type();
        var task = new Task(json.getId(), json.getLabel(), temp, LocalDate.now(), true);
        taskRepository.add(task);
        return taskRepository.getTaskRep();
    }

    @PostMapping("/task/delete/{id}")
    public void deleteById(@PathVariable("id") int id) {
        taskRepository.remove(id);
    }

    @PostMapping("/task/update/{id}")
    public Collection<Task> updateById(@PathVariable("id") int id, @RequestBody JSON json) {
        Objects.requireNonNull(json);
        taskRepository.remove(id);
        Type temp = json.type();
        var task = new Task(json.getId(), json.getLabel(), temp, LocalDate.now(), true);
        taskRepository.add(task);
        return taskRepository.getTaskRep();
    }

    @GetMapping("/task/sortbydate")
    public List<Task> sortByDate() {
        var sorted = taskRepository.getTaskRep();
        sorted.sort(Task::compareByDate);
        return sorted;
    }

    @GetMapping("/task/sortbylabel")
    public List<Task> sortByLabel() {
        var sorted = taskRepository.getTaskRep();
        sorted.sort(Task::compareByLabel);
        return sorted;
    }

}
