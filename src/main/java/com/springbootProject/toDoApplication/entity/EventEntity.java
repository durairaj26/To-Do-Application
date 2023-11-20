package com.springbootProject.toDoApplication.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
//Create an event with name, description, date and time 
//(a field ‘status’ should be managed in the backend,
//the initial value of this would be ‘Pending’).
@Entity
@Table(name="events")
public class EventEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private LocalDateTime dateandtime;
	
	@Column(columnDefinition = "default 'Pending'")
	private String status = "Pending";
	
	public EventEntity(Long id, String name, String description, LocalDateTime dateandtime, String status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateandtime = dateandtime;
		this.status = status;
	}
	
	public EventEntity() {
	
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getdateandtime() {
		return dateandtime;
	}
	public void setdateandtime(LocalDateTime dateandtime) {
		this.dateandtime = dateandtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	//Display Overdue in status field for outdated events
	@Transient
	public String isOverdue() {
	    return ("Pending".equals(status) && dateandtime.isBefore(LocalDateTime.now())) ? "Overdue" : status;
	}

	@Override
	public String toString() {
		return "EventEntity [id=" + id + ", name=" + name + ", description=" + description + ", dateandtime=" + dateandtime
				+ ", status=" + status + "]";
	}
	
	

}
