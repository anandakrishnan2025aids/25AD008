package com.digitalcertificate.repository;

import com.digitalcertificate.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository
        extends JpaRepository<Participant, Long> {
}