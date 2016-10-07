package com.todo.service;

import com.todo.dto.TodoDTO;
import com.todo.dto.TodoDTOMapper;
import com.todo.model.Member;
import com.todo.model.Todo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by fatmaelverir on 06/10/16.
 */
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @Override
    @Transactional
    public void saveTodo(TodoDTO todoDTO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        todoDTO.setCompleted(false);
        todoDTO.setMember(currentPrincipalName);
        todoRepository.save(TodoDTOMapper.todoDTOToTodo(todoDTO));
    }

    public void delete(long todoId) {

        Todo todo = todoRepository.findOne(todoId);
        todoRepository.delete(todo);
    }
    public Todo findOne(long id){
        return todoRepository.findOne(id);
    }

    @Override
    public Iterable<Todo> findAllByMember() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();


        Iterable<Todo> allByMember = null;
        try {
            allByMember = todoRepository.findAllByMember(currentPrincipalName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allByMember;
    }
}
