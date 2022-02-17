package de.bach.springcrud.service;

import de.bach.springcrud.dao.CourseRepository;
import de.bach.springcrud.exception.CourseNotFoundException;
import de.bach.springcrud.model.Course;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    public Course updateCourse(Course course) {
        return repository.save(course);
    }

    public List<Course> findAllCourses() {
        return repository.findAll();
    }

    public Course findCourseById(long courseId) {
        return repository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course by id " + courseId + " was not found"));
    }

    public void deleteCourse(long courseId) {
        repository.deleteById(courseId);
    }

}
