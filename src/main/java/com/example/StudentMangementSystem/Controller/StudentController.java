package com.example.StudentMangementSystem.Controller;

import com.example.StudentMangementSystem.Model.Student;
import com.example.StudentMangementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //    get all data from the db
    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //    build and create a student REST API
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    //    build get employee by id REST API
// Get the student information
    @GetMapping("{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentRepository.findById(id).get();
    }

    // Update the student information
    @PutMapping("{id}")
    public List<Student> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        Student studentObj = studentRepository.findById(id).get();
        studentObj.setF_name(student.getF_name());
        studentObj.setL_name(student.getL_name());
        studentObj.setEmailId(student.getEmailId());
        studentRepository.save(studentObj);
        return studentRepository.findAll();
    }

    // Delete the student
    @DeleteMapping("{id}")
    public List<Student> deleteStudent(@PathVariable Integer id) {
        studentRepository.delete(studentRepository.findById(id).get());
        return studentRepository.findAll();
    }


}
