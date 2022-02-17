package de.bach.springcrud.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import de.bach.springcrud.dao.CourseRepository;
import de.bach.springcrud.service.CourseService;
import org.junit.jupiter.api.Test;

class ExceptionTest {

    @Test
    void courseNotFound() {
        CourseRepository repository = mock(CourseRepository.class);
        CourseService service = new CourseService(repository);
        long id = 1L;

        assertThrows(CourseNotFoundException.class,
                () -> service.findCourseById(id)
        );
    }

}