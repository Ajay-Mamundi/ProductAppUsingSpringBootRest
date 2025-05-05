package com.cts.controller;

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

import com.cts.exceptions.EventNotFoundException;
import com.cts.model.EventManagement;
import com.cts.service.EventManagementService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/events")
public class EventManagementController {
	@Autowired
	private EventManagementService service;
	@PostMapping("/saveevent")
	public String saveEvent(@RequestBody EventManagement event) {
		return service.saveEvent(event);
	}

	@GetMapping("/fetcheventbyid/{eid}")
	public EventManagement getEventById(@PathVariable("eid") Long id) throws EventNotFoundException {
		return service.getEventById(id);
	}

	@PutMapping("/updateevent/{eid}")
	public String updateEvent(@PathVariable("eid") Long id,@RequestBody EventManagement updatedEvent) {
         return service.updateEvent(id, updatedEvent);
		
	}

	@DeleteMapping("/deleteevent/{eid}")
	public String deleteEventById(@PathVariable("eid") Long id) throws EventNotFoundException {
		return service.deleteEventById(id);
	}

	@GetMapping("/fetchallevents")
	public List<EventManagement> getAllEvents() {
		return service.getAllEvents();	}

	@GetMapping("/fetcheventbycategory/{category}")
	public List<EventManagement> getEventByCategory(@PathVariable("category") String category) throws EventNotFoundException {
		return service.getEventByCategory(category);
	}

	

}
