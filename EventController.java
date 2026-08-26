package com.eventify.controller;

import com.eventify.model.Event;
import com.eventify.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EventController {
	@Autowired
	private EventService eventService;
	
	@GetMapping(value="eventify/events",produces= {"application/json"})
	public List<Event>getAllEvents(){
		return eventService.getAllEvents();
		}
	
	@GetMapping (value="eventify/event/{id}",produces= {"application/json"})


    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	@PostMapping(value = "eventify/event" , produces = { "application/json" }, consumes = { "application/json" })
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }
	
	@PutMapping(value="eventify/event/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }
	

    @DeleteMapping(value="eventify/event/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
    
}
