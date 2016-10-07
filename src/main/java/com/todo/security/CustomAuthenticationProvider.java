package com.todo.security;


import com.todo.dto.MemberDTO;
import com.todo.model.Member;
import com.todo.model.Role;
import com.todo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



/**
 * Created by fatmaelverir on 06/10/16.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    MemberService memberService;


    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        MemberDTO memberDTO = memberService.findByUsernameAndPassword(username, password);
        Member member = new Member();
        member.setUsername(memberDTO.getUsername());
        member.setPassword(memberDTO.getPassword());
        member.setId(memberDTO.getId());


        Role r = new Role();
        r.setName("ROLE_USER");
        List<Role> roles = new ArrayList<Role>();
        roles.add(r);


        if (memberDTO == null || !memberDTO.getUsername().equalsIgnoreCase(username)) {
            throw new BadCredentialsException("Username not found.");
        }

        if (!password.equals(memberDTO.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }


        Collection<? extends GrantedAuthority> authorities = roles;

        return new UsernamePasswordAuthenticationToken(member, password, authorities);
    }

    public boolean supports(Class<?> arg0) {
        return true;
    }

}