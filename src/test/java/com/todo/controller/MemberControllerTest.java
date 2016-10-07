package com.todo.controller;

import com.todo.service.MemberService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class MemberControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    MemberController memberController;

    @Mock
    MemberService memberService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
    }


    @Test
    public void testRegister() throws Exception {
        mockMvc.perform(
                post("/member")
                        .param("username", "felverir")
                        .param("password", "12345")
        )
                .andExpect(model().attribute("memberDTO", hasProperty("password", equalTo("12345"))))
                .andExpect(view().name("home"));

    }
}