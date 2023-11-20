package com.springbootProject.toDoApplication.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootProject.toDoApplication.entity.EventEntity;
import com.springbootProject.toDoApplication.repository.EventRepository;

@Service
public class EventServices {

	@Autowired
	private EventRepository eventRepository;
	
	//Create event.
	public EventEntity createEvent(EventEntity eventEntity) {
		return eventRepository.save(eventEntity);
	}
	
	// List out all events.
	public List<EventEntity> getAllEvent() {
		return eventRepository.findAll();
	}

	//Update an existing event by id.
	public EventEntity updateEvent(EventEntity eventEntity, Long id) {
		EventEntity updateEventEntity = eventRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Event not found"));
		updateEventEntity.setName(eventEntity.getName());
		updateEventEntity.setDescription(eventEntity.getDescription());
		updateEventEntity.setdateandtime(eventEntity.getdateandtime());
		return eventRepository.save(updateEventEntity);

	}
	
	//Delete event by id.
	public void deleteEvent(Long id) {
		eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
			eventRepository.deleteById(id);
		
	}
	
	// Change Event status as completed.
	public void changeStatusAsCompleted(Long id) {

		EventEntity findEventId = eventRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Event not found"));
		findEventId.setStatus("Completed");
		eventRepository.save(findEventId);
	}

	//Group events by status of each event.
	public Map<String, List<EventEntity>> getGroup() {
	    List<EventEntity> overdueEvents = eventRepository.findAll().stream()
	            .filter(event -> "Overdue".equals(event.isOverdue()))
	            .peek(event -> event.setStatus("Overdue"))
	            .collect(Collectors.toList());

	    Map<String, List<EventEntity>> groupByStatus = eventRepository.findAll().stream()
	            .collect(Collectors.groupingBy(EventEntity::getStatus));

	    groupByStatus.put("Overdue", overdueEvents);

	    return groupByStatus;
	}

}
