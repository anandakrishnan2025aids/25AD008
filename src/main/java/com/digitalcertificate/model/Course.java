package com.digitalcertificate.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Course {
    @OneToMany(mappedBy = "course")
    private List<Certificate> certificates;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseName;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

}