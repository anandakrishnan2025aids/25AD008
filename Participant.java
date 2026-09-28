package com.digitalcertificate.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participantId;

    private String name;

    private String email;

    private String phone;

    private LocalDateTime createdAt;

}