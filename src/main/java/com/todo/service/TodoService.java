package com.todo.service;

import com.todo.dto.TodoDTO;
import com.todo.model.Todo;
import org.springframework.stereotype.Service;


/**
 * Created by fatmaelverir on 06/10/16.
 */
@Service
public interface TodoService {
    Iterable<Todo> findAllByMember();

    void saveTodo(TodoDTO todoDTO);

    Todo findOne(long id);


    void delete(long todoId);

}
