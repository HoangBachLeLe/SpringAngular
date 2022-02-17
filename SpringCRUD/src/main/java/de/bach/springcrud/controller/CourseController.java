package de.bach.springcrud.controller;

import de.bach.springcrud.model.Course;
import de.bach.springcrud.service.CourseService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @PostMapping("/postcourse")
    public List<Course> saveCourse(@RequestBody Course course) {
        service.saveCourse(course);
        return service.findAllCourses();
    }

    @PutMapping("/updatecourse")
    public List<Course> updateCourse(@RequestBody Course course) {
        service.updateCourse(course);
        return service.findAllCourses();
    }

    @GetMapping("/getallcourses")
    public List<Course> getCourses() {
        return service.findAllCourses();
    }

    @GetMapping("/getcoursebyid")
    public Course getCourseById(@RequestParam long courseId) {
        return service.findCourseById(courseId);
    }

    @DeleteMapping("/deletecourse")
    public List<Course> deleteCourse(@RequestParam long courseId) {
        service.deleteCourse(courseId);
        return service.findAllCourses();
    }
}
