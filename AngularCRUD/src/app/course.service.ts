import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Course } from './model/course';

@Injectable({
  providedIn: 'root',
})
export class CourseService {
  constructor(private http: HttpClient) {}

  public postCourse(course: Course) {
    return this.http.post('http://localhost:8080/postcourse', course, {
      responseType: 'text' as 'json',
    });
  }

  public updateCourse(course: Course) {
    return this.http.put('http://localhost:8080/updatecourse', course, {
      responseType: 'text' as 'json',
    });
  }

  public getCourses() {
    return this.http.get('http://localhost:8080/getallcourses');
  }

  public getCourseById(courseId: number) {
    return this.http.get(
      'http://localhost:8080/getcoursebyid?courseId=' + courseId
    );
  }

  public deleteCourse(courseId: number) {
    return this.http.delete(
      'http://localhost:8080/deletecourse?courseId=' + courseId
    );
  }
}
