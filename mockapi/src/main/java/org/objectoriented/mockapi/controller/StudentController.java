package org.objectoriented.mockapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.objectoriented.mockapi.entity.impl.Student;
import org.objectoriented.mockapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "university")
@Tag(name="Student", description="Endpoints for managing the students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/students/id/{id}")
    public ResponseEntity getStudentsById(@PathVariable("id") int id) {
        Student student = studentService.getByStudentId(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/students/faculty/{faculty}")
    public ResponseEntity getStudentsByFaculty(@PathVariable("faculty") int facultyId) {
        List<Student> studentList = studentService.getByFacultyId(facultyId);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/students/grade/{averageGrade}")
    public ResponseEntity getStudentsByAverageGrade(@PathVariable("averageGrade") double averageGrade) {
        List<Student> studentList = studentService.getByAverageGrade(averageGrade);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}
