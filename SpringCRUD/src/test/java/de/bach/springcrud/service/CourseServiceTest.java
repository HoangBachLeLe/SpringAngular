package de.bach.springcrud.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import de.bach.springcrud.dao.CourseRepository;
import de.bach.springcrud.model.Course;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    private Course course;

    @Mock
    private CourseRepository repository;

    @InjectMocks
    private CourseService service;

    @BeforeEach
    void setUp() {
        course = new Course(1L, "Spring Magic", "400");
    }

    @Test
    void saveCourse() {
        when(repository.save(course)).thenReturn(course);

        Course savedCourse = service.saveCourse(course);

        assertThat(savedCourse).isEqualTo(course);
        verify(repository).save(course);
    }

    @Test
    void updateCourse() {
        when(repository.save(course)).thenReturn(course);

        Course savedCourse = service.updateCourse(course);

        assertThat(savedCourse).isEqualTo(course);
        verify(repository).save(course);
    }

    @Test
    void findAllCourses() {
        service.findAllCourses();

        verify(repository).findAll();
    }

    @Test
    void findCourseById() {
        long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.of(course));

        Course courseById = service.findCourseById(id);

        assertThat(courseById).isEqualTo(course);
        verify(repository).findById(id);
    }

    @Test
    void deleteCourse() {
        long id = 1L;

        service.deleteCourse(id);

        verify(repository).deleteById(id);
    }
}