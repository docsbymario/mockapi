package org.objectoriented.mockapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.objectoriented.mockapi.entity.impl.Faculty;
import org.objectoriented.mockapi.entity.impl.Student;
import org.objectoriented.mockapi.service.FacultyService;
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
@Tag(name="Faculty", description="Endpoints for managing the faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/faculties")
    public ResponseEntity getAllFaculties() {
        List<Faculty> facultyList = facultyService.getAllFaculties();
        return new ResponseEntity<>(facultyList, HttpStatus.OK);
    }

    @GetMapping("/faculties/id/{id}")
    public ResponseEntity getFacultiesById(@PathVariable("id") int id) {
        Faculty faculty = facultyService.getByFacultyId(id);
        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }

    @GetMapping("/faculties/location/{faculty}")
    public ResponseEntity getFacultiesByLocation(@PathVariable("location") String location) {
        List<Faculty> facultyList = facultyService.getByLocation(location);
        return new ResponseEntity<>(facultyList, HttpStatus.OK);
    }
}
