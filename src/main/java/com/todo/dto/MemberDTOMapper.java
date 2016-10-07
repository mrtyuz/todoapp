package com.todo.dto;


import com.todo.model.Member;

/**
 * Created by fatmaelverir on 06/10/16.
 */
public class MemberDTOMapper {
    public static Member memberDTOToMember(MemberDTO memberDTO) {
        if (memberDTO == null) {
            return null;
        }
        Member member = new Member();
        member.setEmail(memberDTO.getEmail());
        member.setPassword(memberDTO.getPassword());
        member.setUsername(memberDTO.getUsername());
        return member;
    }


    public static MemberDTO memberToMemberDTO(Member member) {
        if (member == null) {
            return null;
        }
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setUsername(member.getUsername());
        memberDTO.setPassword(member.getPassword());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setId(member.getId());
        return memberDTO;
    }
}
