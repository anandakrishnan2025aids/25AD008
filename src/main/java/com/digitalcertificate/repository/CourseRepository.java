package com.digitalcertificate.repository;

import com.digitalcertificate.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository
        extends JpaRepository<Course, Long> {
}