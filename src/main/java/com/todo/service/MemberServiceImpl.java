package com.todo.service;

import com.todo.dto.MemberDTO;
import com.todo.dto.MemberDTOMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by fatmaelverir on 06/10/16.
 */
@Service
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberDTO findByUsernameAndPassword(String username, String password) {
        return MemberDTOMapper.memberToMemberDTO(memberRepository.findByUsernameAndPassword(username, password));
    }

    @Override
    public MemberDTO findByUsername(String username) {
        return MemberDTOMapper.memberToMemberDTO(memberRepository.findByUsername(username));
    }

    @Override
    @Transactional
    public void saveMember(MemberDTO memberDTO) {
        if (findByUsername(memberDTO.getUsername()) == null) {
            memberRepository.save(MemberDTOMapper.memberDTOToMember(memberDTO));
        }
    }
}
