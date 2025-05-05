package com.cts.exceptions;

public class EventNotFoundException extends Exception{
	  public EventNotFoundException(Long id) {
	        super("User not found with id: " + id);
	    }
	  public EventNotFoundException(String category) {
	        super("Event not found with category: " + category);
	    }

}
