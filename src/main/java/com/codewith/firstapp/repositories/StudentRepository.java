package com.codewith.firstapp.repositories;

import com.codewith.firstapp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByDepartment(String department);
}