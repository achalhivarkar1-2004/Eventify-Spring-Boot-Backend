package com.eventify.repository;
import com.eventify.model.Organizer;
import com.eventify.model.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

}