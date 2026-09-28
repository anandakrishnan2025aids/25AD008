package com.digitalcertificate.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseName;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

}