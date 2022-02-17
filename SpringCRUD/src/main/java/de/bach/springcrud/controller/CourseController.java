package de.bach.springcrud.controller;

import de.bach.springcrud.model.Course;
import de.bach.springcrud.service.CourseService;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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

    @SuppressFBWarnings("EI_EXPOSE_REP2")
    private final CourseService service;

    @PostMapping("/postcourse")
    public List<Course> saveCourse(final @RequestBody Course course) {
        service.saveCourse(course);
        return service.findAllCourses();
    }

    @PutMapping("/updatecourse")
    public List<Course> updateCourse(final @RequestBody Course course) {
        service.updateCourse(course);
        return service.findAllCourses();
    }

    @GetMapping("/getallcourses")
    public List<Course> getCourses() {
        return service.findAllCourses();
    }

    @GetMapping("/getcoursebyid")
    public Course getCourseById(final @RequestParam long courseId) {
        return service.findCourseById(courseId);
    }

    @DeleteMapping("/deletecourse")
    public List<Course> deleteCourse(final @RequestParam long courseId) {
        service.deleteCourse(courseId);
        return service.findAllCourses();
    }
}
