package com.eventify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eventify.model.Attendee;
import com.eventify.model.AccountStatus;
import java.util.List;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {

}