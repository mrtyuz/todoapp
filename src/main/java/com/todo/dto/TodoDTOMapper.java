package com.todo.dto;


import com.todo.model.Todo;

/**
 * Created by fatmaelverir on 06/10/16.
 */
public class TodoDTOMapper {

    public static Todo todoDTOToTodo(TodoDTO todoDTO) {
        if (todoDTO == null) {
            return null;
        }
        Todo todo = new Todo();
        todo.setName(todoDTO.getName());
        todo.setCompleted(todoDTO.isCompleted());
        todo.setMember(todoDTO.getMember());

        return todo;
    }


    public static TodoDTO todoToTodoDTO(Todo todo) {
        if (todo == null) {
            return null;
        }
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setName(todo.getName());
        todoDTO.setCompleted(todo.isCompleted());
        todoDTO.setMember(todo.getMember());
        todoDTO.setId(todo.getId());
        return todoDTO;
    }
}
