package de.bach.springcrud.exception;

@SuppressWarnings("PMD")
public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(String message) {
        super(message);
    }

}
