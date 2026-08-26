package com.eventify.service;
import com.eventify.model.Event;
import com.eventify.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;
	  public List<Event> getAllEvents()
	  {
	        return eventRepository.findAll();
	    }
	  public Event createEvent(Event event) {
	        return eventRepository.save(event);
	    }
	    public Optional<Event> getEventById(Long id) {
	        return eventRepository.findById(id);
	    }
	    public Event updateEvent(Long id, Event updatedEvent) {
	        Event event = eventRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Event not found"));
	        event.setTitle(updatedEvent.getTitle());
	        event.setDescription(updatedEvent.getDescription());
	        event.setStatus(updatedEvent.getStatus());
	        return eventRepository.save(event);
	    }
	    public void deleteEvent(Long id) {
	        eventRepository.deleteById(id);
	    } 
}
