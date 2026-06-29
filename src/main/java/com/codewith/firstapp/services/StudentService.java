package com.codewith.firstapp.services;

import com.codewith.firstapp.models.Student;
import com.codewith.firstapp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getStudents() {
        return repo.findAll();
    }

    public Student addStudent(Student s) {
        return repo.save(s);
    }

    public Student updateStudent(Long id, Student s) {
        Student st = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));

        st.setName(s.getName());
        st.setEmail(s.getEmail());
        st.setPhone(s.getPhone());
        st.setDepartment(s.getDepartment());
        st.setYear(s.getYear());

        return repo.save(st);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }

    public List<Student> searchByDepartment(String dept) {
        return repo.findByDepartment(dept);
    }
}