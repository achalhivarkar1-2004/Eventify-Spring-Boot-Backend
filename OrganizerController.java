package com.eventify.controller;

import com.eventify.model.Organizer;
import com.eventify.service.OrganizerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    @GetMapping(value = "eventify/organizers", produces = {"application/json"})
    public List<Organizer> getAllOrganizers() {
        return organizerService.getAllOrganizers();
    }

    @GetMapping(value = "eventify/organizer/{id}", produces = {"application/json"})
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id) {

        return organizerService.getOrganizerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "eventify/organizer",
            consumes = {"application/json"},
            produces = {"application/json"})
    public Organizer createOrganizer(@RequestBody Organizer organizer) {

        return organizerService.createOrganizer(organizer);
    }

    @PutMapping(value = "eventify/organizer/{id}")
    public Organizer updateOrganizer(@PathVariable Long id,
                                     @RequestBody Organizer organizer) {

        return organizerService.updateOrganizer(id, organizer);
    }

    @DeleteMapping(value = "eventify/organizer/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {

        organizerService.deleteOrganizer(id);

        return ResponseEntity.noContent().build();
    }
}