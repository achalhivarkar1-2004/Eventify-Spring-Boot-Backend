package com.eventify.service;

import com.eventify.model.Attendee;
import com.eventify.repository.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendeeService {

    @Autowired
    private AttendeeRepository attendeeRepository;

    public List<Attendee> getAllAttendees() {
        return attendeeRepository.findAll();
    }

    public Attendee createAttendee(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }

    public Optional<Attendee> getAttendeeById(Long id) {
        return attendeeRepository.findById(id);
    }

    public Attendee updateAttendee(Long id, Attendee updatedAttendee) {

        Attendee attendee = attendeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendee not found"));

        attendee.setName(updatedAttendee.getName());
        attendee.setEmail(updatedAttendee.getEmail());
        attendee.setPhone(updatedAttendee.getPhone());
        attendee.setPasswordHash(updatedAttendee.getPasswordHash());
        attendee.setAccountStatus(updatedAttendee.getAccountStatus());

        return attendeeRepository.save(attendee);
    }

    public void deleteAttendee(Long id) {
        attendeeRepository.deleteById(id);
    }
}