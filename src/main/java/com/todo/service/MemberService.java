package com.todo.service;

import com.todo.dto.MemberDTO;
import com.todo.model.Member;

/**
 * Created by fatmaelverir on 06/10/16.
 */
public interface MemberService {
    MemberDTO findByUsernameAndPassword(String rn, String password);

    void saveMember(MemberDTO memberDTO);

    MemberDTO findByUsername(String username);
}
