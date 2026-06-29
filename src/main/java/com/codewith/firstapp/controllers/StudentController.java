package com.codewith.firstapp.controllers;

import com.codewith.firstapp.models.Student;
import com.codewith.firstapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> get() {
        return service.getStudents();
    }

    @PostMapping
    public Student add(@RequestBody Student s) {
        return service.addStudent(s);
    }

    @PostMapping("/search")
    public List<Student> search(@RequestBody Student s) {
        return service.searchByDepartment(s.getDepartment());
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) {
        return service.updateStudent(id, s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}