package com.springbootProject.toDoApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootProject.toDoApplication.entity.EventEntity;
import com.springbootProject.toDoApplication.services.EventServices;

@RestController
@RequestMapping(path="/events", produces={"application/json"}, consumes= {"application/json"})
public class EventController {
	
	@Autowired
	private EventServices eventService;
	
	@PostMapping("/create")
	public EventEntity createEvent(@RequestBody EventEntity eventEntity) {
		return eventService.createEvent(eventEntity);
	}
	
	//Get all the created events.
	@GetMapping("/allEvents")
	public List<EventEntity> getAllEvent(){
		return eventService.getAllEvent();
	}
	
	//Update an existing event
	@PutMapping("/update")
	public void updateEvent(@RequestBody EventEntity eventEntity) {
		eventService.updateEvent(eventEntity);
	}
	
	//Delete an existing event
	@DeleteMapping("/delete/{id}")
	public void deleteEvent(@PathVariable Long id) {
		eventService.deleteEvent(id);
	}

}
