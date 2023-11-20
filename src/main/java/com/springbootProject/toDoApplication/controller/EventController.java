package com.springbootProject.toDoApplication.controller;

import java.util.List;
import java.util.Map;

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
	
	@PostMapping(path="/create")
	public EventEntity createEvent(@RequestBody EventEntity eventEntity) {
		return eventService.createEvent(eventEntity);
	}
	
	//Get all the created events.
	@GetMapping(path="/listAll")
	public List<EventEntity> getAllEvent(){
		
		return eventService.getAllEvent();
	}
	
	//Update an existing event

	@PutMapping(path="/update/{id}")
	public EventEntity updateEvent(@RequestBody EventEntity eventEntity, @PathVariable Long id) {
		return eventService.updateEvent(eventEntity, id);
	}

	//Delete an existing event
	@DeleteMapping("/delete/{id}")
	public void deleteEvent(@PathVariable Long id) {
		eventService.deleteEvent(id);
	}
	
	//Change status as pending to completed
	@PostMapping("/changeStatus/{id}")
	public void changeStatusAsCompleted(@PathVariable Long id) {
		eventService.changeStatusAsCompleted(id);
	}
	
	//Group events by status
	@GetMapping("/groups")
	public Map<String, List<EventEntity>> getGroup(){
		return eventService.getGroup();
	}

}
