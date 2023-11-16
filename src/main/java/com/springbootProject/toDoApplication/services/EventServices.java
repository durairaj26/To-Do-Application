package com.springbootProject.toDoApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootProject.toDoApplication.entity.EventEntity;
import com.springbootProject.toDoApplication.repository.EventRepository;

@Service
public class EventServices {
	
	@Autowired
	private EventRepository eventRepository;
	
	public EventEntity createEvent(EventEntity eventEntity) {
		return eventRepository.save(eventEntity);
	}
	
	public List<EventEntity> getAllEvent(){
		return eventRepository.findAll();
		
	}
	
	public void updateEvent(EventEntity eventEntity) {
		eventRepository.save(eventEntity);
	}
	
	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}

}
