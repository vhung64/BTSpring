package com.example.baithday02.service;

import com.example.baithday02.exception.NotFoundException;
import com.example.baithday02.model.Todo;
import com.example.baithday02.request.TodoRequest;
import com.example.baithday02.request.UpdateRepuestTodo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ToDoService {
    private List<Todo> list;
    public ToDoService(){
        list = new ArrayList<>();
        list.add(new Todo(247, "Đi đá bóng",false));
        list.add(new Todo(230, "Làm bài tập",false));
        list.add(new Todo(963, "Đi chơi với bạn bè",true));
    }

    public List<Todo> getList() {
        return list;
    }

    public Todo creatToDO(TodoRequest todo) {
        Random random = new Random();
        int id = random.nextInt(900) + 100;
        while (findbyID(id).isPresent()){
            id = random.nextInt(900) + 100;
        }
        Todo todo1 = new Todo(id, todo.getTitle(),false);
        list.add(todo1);
        return todo1;
    }

    public Todo updateTodo(UpdateRepuestTodo todo, int id) {
        for (Todo todo1 : list){
            if(todo1.getId() == id){
                if(todo.getTitle() != null) {
                    todo1.setTitle(todo.getTitle());
                }else {
                    todo1.setStatus(todo.isStatus());
                }
                return todo1;
            }
        }
        throw new NotFoundException("Khong co todo co id la : " + id);
    }
    public Optional<Todo> findbyID(int id){
        return list.stream().filter(todo -> todo.getId() == id).findFirst();
    }
    public void delTodo(int id) {
        list.removeIf(todo -> todo.getId() == id);
    }
}
