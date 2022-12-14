package com.example.baithday02.controller;

import com.example.baithday02.model.Todo;
import com.example.baithday02.request.TodoRequest;
import com.example.baithday02.request.UpdateRepuestTodo;
import com.example.baithday02.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TodoController {
    @Autowired
    private ToDoService toDoService;
    @GetMapping("todos")
    public List<Todo> getTools(){
        return toDoService.getList();
    }
    @PostMapping("todos")
    public Todo creatToDo(@RequestBody TodoRequest todo){
        return toDoService.creatToDO(todo);
    }
    @PutMapping("todos/{id}")
    public Todo updateTodo(@RequestBody UpdateRepuestTodo todo,@PathVariable int id){
        return toDoService.updateTodo(todo,id);
    }
    @DeleteMapping("todos/{id}")
    public void delTodo(@PathVariable int id){
        toDoService.delTodo(id);
    }
}
