package com.todo.service;

import com.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fatmaelverir on 06/10/16.
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Iterable<Todo> findAllByMember(String username);
}
