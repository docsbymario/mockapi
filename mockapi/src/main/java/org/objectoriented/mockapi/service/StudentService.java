package org.objectoriented.mockapi.service;

import org.objectoriented.mockapi.entity.impl.Student;
import org.objectoriented.mockapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getAllStudents() {
        return studentRepository.getAll();
    }

    public Student getByStudentId(int id) {
        return studentRepository.getById(id);
    }

    public List<Student> getByFacultyId(int facultyId) {
        return studentRepository.getByFaculty(facultyId);
    }

    public List<Student> getByAverageGrade(double averageGrade) {
        return studentRepository.getByAverageGrade(averageGrade);
    }
}
