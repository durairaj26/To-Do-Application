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
	
	public EventEntity updateEvent(EventEntity eventEntity, Long id) {
			EventEntity updateEventEntity= eventRepository.findById(id).orElseThrow(()->new RuntimeException("Event not found"));
			updateEventEntity.setName(eventEntity.getName());
			updateEventEntity.setDescription(eventEntity.getDescription());
			updateEventEntity.setdateandtime(eventEntity.getdateandtime());
			return eventRepository.save(updateEventEntity);
		
	}

		
	public void deleteEvent(Long id) {
		EventEntity findEventId= eventRepository.findById(id).orElseThrow(()-> new RuntimeException("Event not found"));
		if(findEventId.equals(id)) {
			eventRepository.deleteById(id);
		}
	}
	
	
	public void changeStatusAsCompleted(Long id) {
		EventEntity findEventId= eventRepository.findById(id).orElseThrow(()-> new RuntimeException("Event not found"));
		findEventId.setStatus("Completed");
		eventRepository.save(findEventId);
	}
	
	
	public List<EventEntity> groupEventByStatus(String status) {
		return eventRepository.findEventByStatus(status);
	}
	
	
//	 public List<EventEntity> getGroupEventByStatus(){
//		  List<EventEntity> pendingEvents = groupEventByStatus("Pending");
//		  List<EventEntity> completedEvents = groupEventByStatus("Pending");
//		  List<EventEntity> overdueEvent = eventRepository.findAll().stream()
//	                .filter(t->!"Completed".equals(t.getStatus()) && LocalDateTime.now().isAfter(t.getdateandtime()))
//	                .map(EventEntity).
//	                .toList();
//		  pendingEvents.addAll(overdueEvent);
//		  pendingEvents.addAll(completedEvents);
//		  return overdueEvent;
//	 }

}
