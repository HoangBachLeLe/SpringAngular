package de.bach.springcrud.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.bach.springcrud.model.Course;
import de.bach.springcrud.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = CourseController.class)
class CourseControllerTest {

    private Course course;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CourseService service;

    @BeforeEach
    void setUp() {
        course = new Course(1L, "Spring Magic", "200");
    }

    @Test
    void saveCourse() throws Exception {
        ArgumentCaptor<Course> courseArgumentCaptor = ArgumentCaptor.forClass(Course.class);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/postcourse")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(course)))
                .andExpect(status().isOk());

        verify(service).saveCourse(courseArgumentCaptor.capture());
        assertThat(courseArgumentCaptor.getValue().getCourseId()).isEqualTo(course.getCourseId());
        assertThat(courseArgumentCaptor.getValue().getCourseName()).isEqualTo(course.getCourseName());
        assertThat(courseArgumentCaptor.getValue().getFees()).isEqualTo(course.getFees());
    }


    @Test
    void updateCourse() throws Exception {
        ArgumentCaptor<Course> courseArgumentCaptor = ArgumentCaptor.forClass(Course.class);

        mockMvc.perform(
                        MockMvcRequestBuilders.put("/updatecourse")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(course)))
                .andExpect(status().isOk());

        verify(service).updateCourse(courseArgumentCaptor.capture());
        assertThat(courseArgumentCaptor.getValue().getCourseId()).isEqualTo(course.getCourseId());
        assertThat(courseArgumentCaptor.getValue().getCourseName()).isEqualTo(course.getCourseName());
        assertThat(courseArgumentCaptor.getValue().getFees()).isEqualTo(course.getFees());
    }

    @Test
    void getCourses() throws Exception {
        mockMvc.perform(get("/getallcourses"));

        verify(service).findAllCourses();
    }

    @Test
    void getCourseById() throws Exception {
        long id = 1L;
        mockMvc.perform(get("/getcoursebyid?courseId=" + id));

        verify(service).findCourseById(id);
    }

    @Test
    void deleteCourse() throws Exception {
        long id = 1L;
        mockMvc.perform(delete("/deletecourse?courseId=" + id));

        verify(service).deleteCourse(id);
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}