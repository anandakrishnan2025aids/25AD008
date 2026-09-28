package com.digitalcertificate.controller;

import com.digitalcertificate.model.Course;
import com.digitalcertificate.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course createCourse(
            @RequestBody Course course) {

        return courseService.saveCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {

        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(
            @PathVariable Long id) {

        return courseService.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(
            @PathVariable Long id) {

        courseService.deleteCourse(id);

        return "Course deleted successfully";
    }
}