package de.bach.springcrud.dao;

import de.bach.springcrud.model.Course;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

    @Override
    List<Course> findAll();

}
