package com.eventify.controller;

import com.eventify.model.Attendee;
import com.eventify.service.AttendeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendeeController {

    @Autowired
    private AttendeeService attendeeService;

    @GetMapping(value = "eventify/attendees", produces = {"application/json"})
    public List<Attendee> getAllAttendees() {
        return attendeeService.getAllAttendees();
    }

    @GetMapping(value = "eventify/attendee/{id}", produces = {"application/json"})
    public ResponseEntity<Attendee> getAttendeeById(@PathVariable Long id) {

        return attendeeService.getAttendeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "eventify/attendee",
            consumes = {"application/json"},
            produces = {"application/json"})
    public Attendee createAttendee(@RequestBody Attendee attendee) {

        return attendeeService.createAttendee(attendee);
    }

    @PutMapping(value = "eventify/attendee/{id}")
    public Attendee updateAttendee(@PathVariable Long id,
                                   @RequestBody Attendee attendee) {

        return attendeeService.updateAttendee(id, attendee);
    }

    @DeleteMapping(value = "eventify/attendee/{id}")
    public ResponseEntity<Void> deleteAttendee(@PathVariable Long id) {

        attendeeService.deleteAttendee(id);

        return ResponseEntity.noContent().build();
    }
}