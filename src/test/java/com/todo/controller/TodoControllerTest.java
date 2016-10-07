package com.todo.controller;

import com.todo.model.Todo;
import com.todo.service.TodoRepository;
import com.todo.service.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class TodoControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    TodoController todoController;

    @Mock
    TodoService todoService;

    @Mock
    TodoRepository todoRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(todoController).build();
    }

    @Test
    public void testGetAllByMember() throws Exception {

        List<Todo> todos = new ArrayList<>();
        when(todoService.findAllByMember()).thenReturn(todos);

        mockMvc.perform(get("/todo-list"))
                .andExpect(model().attribute("todos", equalTo(todos)))
                .andExpect(view().name("todolist"));
    }

}