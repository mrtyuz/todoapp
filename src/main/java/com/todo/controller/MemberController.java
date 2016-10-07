package com.todo.controller;

import com.todo.dto.MemberDTO;
import com.todo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by fatmaelverir on 06/10/16.
 */
@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/member")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        memberService.saveMember(memberDTO);
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "register";
    }

}
