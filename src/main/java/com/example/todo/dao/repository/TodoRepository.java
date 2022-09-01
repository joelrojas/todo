package com.example.todo.dao.repository;

import com.example.todo.dao.TodoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    Page<TodoEntity> findAll(Pageable pageable);

    @Query(value = "select * from todo where status = 1",
            countQuery = "SELECT COUNT(*) FROM todo WHERE status = 1",
            nativeQuery = true)
    Page<TodoEntity> findAllActive(Pageable pageable);
}
