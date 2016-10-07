package com.todo.service;

import com.todo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by fatmaelverir on 06/10/16.
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsernameAndPassword(String rn, String password);
    Member findByUsername(String username);
}
