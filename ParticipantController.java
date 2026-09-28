package com.digitalcertificate.controller;

import com.digitalcertificate.model.Participant;
import com.digitalcertificate.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping
    public Participant createParticipant(
            @RequestBody Participant participant) {

        return participantService
                .saveParticipant(participant);
    }

    @GetMapping
    public List<Participant> getAllParticipants() {

        return participantService
                .getAllParticipants();
    }

    @GetMapping("/{id}")
    public Participant getParticipant(
            @PathVariable Long id) {

        return participantService
                .getParticipantById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteParticipant(
            @PathVariable Long id) {

        participantService.deleteParticipant(id);

        return "Participant deleted successfully";
    }
}