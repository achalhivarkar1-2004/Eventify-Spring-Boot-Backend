package com.eventify.controller;

import com.eventify.model.Registration;
import com.eventify.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping(value = "eventify/registrations", produces = {"application/json"})
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @GetMapping(value = "eventify/registration/{id}", produces = {"application/json"})
    public ResponseEntity<Registration> getRegistrationById(@PathVariable Long id) {

        return registrationService.getRegistrationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "eventify/registration",
            consumes = {"application/json"},
            produces = {"application/json"})
    public Registration createRegistration(@RequestBody Registration registration) {

        return registrationService.createRegistration(registration);
    }

    @PutMapping(value = "eventify/registration/{id}")
    public Registration updateRegistration(@PathVariable Long id,
                                           @RequestBody Registration registration) {

        return registrationService.updateRegistration(id, registration);
    }

    @DeleteMapping(value = "eventify/registration/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Long id) {

        registrationService.deleteRegistration(id);

        return ResponseEntity.noContent().build();
    }
}