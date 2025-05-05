package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.controller.EventManagementController;
import com.cts.exceptions.EventNotFoundException;
import com.cts.model.EventManagement;
import com.cts.repository.EventManagementRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventManagementServiceImpl implements EventManagementService {
	@Autowired
	private EventManagementRepository repository;

	@Override
	public String saveEvent(EventManagement event) {
		repository.save(event);
		return "Event created successfully..!!";
	}

	@Override
	public EventManagement getEventById(Long id) throws EventNotFoundException {
		Optional<EventManagement> optional = repository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			throw new EventNotFoundException("Invalid Event ID");
	}

	@Override
	public String updateEvent(Long id, EventManagement updatedEvent) {

		Optional<EventManagement> optional = repository.findById(id);
		if (optional.isPresent()) {
			EventManagement existingEvent = optional.get();
			existingEvent.setEventName(updatedEvent.getEventName());
			existingEvent.setEventCategory(updatedEvent.getEventCategory());
			existingEvent.setEventLocation(updatedEvent.getEventLocation());
			existingEvent.setEventDate(updatedEvent.getEventDate());
			existingEvent.setEventOrganizerId(updatedEvent.getEventOrganizerId());
			repository.save(existingEvent);
			return "Event updated successfully..!";
		} else {
			throw new EntityNotFoundException("Event not found with id: " + id);
		}
	}

	@Override
	public String deleteEventById(Long id) throws EventNotFoundException {
		if (!repository.existsById(id)) {			
			throw new EventNotFoundException(id);
		}
		repository.deleteById(id);
        return "Event deleted successfully";
	}

	@Override
	public List<EventManagement> getAllEvents() {
		return repository.findAll();
	}

	@Override
	public List<EventManagement> getEventByCategory(String category) throws EventNotFoundException {
		List<EventManagement> events = repository.findByEventCategory(category);
		if(events.isEmpty()) {
			throw new EventNotFoundException(category);
		}
		return events;
	}

}
