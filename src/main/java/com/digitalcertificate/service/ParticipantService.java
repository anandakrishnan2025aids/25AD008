package com.digitalcertificate.service;

import com.digitalcertificate.model.Participant;
import com.digitalcertificate.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public Participant saveParticipant(
            Participant participant) {

        return participantRepository.save(participant);
    }

    public List<Participant> getAllParticipants() {

        return participantRepository.findAll();
    }

    public Participant getParticipantById(Long id) {

        return participantRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Participant not found"));
    }

    public void deleteParticipant(Long id) {

        participantRepository.deleteById(id);
    }
}