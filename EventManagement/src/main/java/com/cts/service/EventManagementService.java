package com.cts.service;

import java.util.*;

import com.cts.exceptions.EventNotFoundException;
import com.cts.model.EventManagement;

public interface EventManagementService {

	public abstract String saveEvent(EventManagement event);

	public abstract EventManagement getEventById(Long id) throws EventNotFoundException;

	public abstract String updateEvent(Long id, EventManagement updatedEvent);

	public abstract String deleteEventById(Long id) throws EventNotFoundException;

	public abstract List<EventManagement> getAllEvents();

	public abstract List<EventManagement> getEventByCategory(String category) throws EventNotFoundException;
}
