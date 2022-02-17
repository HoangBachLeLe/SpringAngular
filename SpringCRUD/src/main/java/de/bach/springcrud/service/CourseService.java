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

    public Course saveCourse(final Course course) {
        return repository.save(course);
    }

    public Course updateCourse(final Course course) {
        return repository.save(course);
    }

    public List<Course> findAllCourses() {
        return repository.findAll();
    }

    public Course findCourseById(final long courseId) {
        return repository.findById(courseId). //NOPMD
                orElseThrow(() -> new CourseNotFoundException("Course by id " + courseId + " was not found"));
    }

    public void deleteCourse(final long courseId) {
        repository.deleteById(courseId);
    }

}
