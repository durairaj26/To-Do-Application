package com.springbootProject.toDoApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootProject.toDoApplication.entity.EventEntity;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

}
