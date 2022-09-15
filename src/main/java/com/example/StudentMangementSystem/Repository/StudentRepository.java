package com.example.StudentMangementSystem.Repository;

import com.example.StudentMangementSystem.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
