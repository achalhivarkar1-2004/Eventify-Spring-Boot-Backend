package com.eventify.service;

import com.eventify.model.Registration;
import com.eventify.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Registration createRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }

    public Optional<Registration> getRegistrationById(Long id) {
        return registrationRepository.findById(id);
    }

    public Registration updateRegistration(Long id, Registration updatedRegistration) {

        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found"));

        registration.setEvent(updatedRegistration.getEvent());
        registration.setAttendee(updatedRegistration.getAttendee());
        registration.setRegistrationDate(updatedRegistration.getRegistrationDate());
        registration.setPaymentStatus(updatedRegistration.getPaymentStatus());
        registration.setTicketNumber(updatedRegistration.getTicketNumber());

        return registrationRepository.save(registration);
    }

    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }
}