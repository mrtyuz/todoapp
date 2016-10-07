package com.todo.controller;

import com.todo.dto.TodoDTO;
import com.todo.model.Member;
import com.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fatmaelverir on 06/10/16.
 */
@Controller
@RequestMapping("/todo-list")
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllByMember(Model model) {

        model.addAttribute("todos", todoService.findAllByMember());
        return "todolist";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String createTodo(Model model, @ModelAttribute TodoDTO todoDTO) {
        todoService.saveTodo(todoDTO);
        model.addAttribute("todos", todoService.findAllByMember());

        return "todolist";
    }


    @RequestMapping(value="/doDelete", method = RequestMethod.POST)
    public String deleteTodo (Model model,@RequestParam Long id) {
        todoService.delete(id);
        model.addAttribute("todos", todoService.findAllByMember());

        return "todolist";
    }
}
