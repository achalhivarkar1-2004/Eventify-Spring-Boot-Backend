package com.eventify.service;

import com.eventify.model.Organizer;
import com.eventify.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Optional<Organizer> getOrganizerById(Long id) {
        return organizerRepository.findById(id);
    }

    public Organizer updateOrganizer(Long id, Organizer updatedOrganizer) {

        Organizer organizer = organizerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizer not found"));

        organizer.setName(updatedOrganizer.getName());
        organizer.setEmail(updatedOrganizer.getEmail());
        organizer.setPhone(updatedOrganizer.getPhone());
        organizer.setOrganizationName(updatedOrganizer.getOrganizationName());
        organizer.setPasswordHash(updatedOrganizer.getPasswordHash());
        organizer.setAccountStatus(updatedOrganizer.getAccountStatus());

        return organizerRepository.save(organizer);
    }

    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }
}