package com.digitalcertificate.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VerificationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    private LocalDateTime verificationTime;

    private String result;

}