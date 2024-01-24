package com.example.StudentDB.Controller;

import com.example.StudentDB.Entity.Student;
import com.example.StudentDB.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping
    public Collection<Student> getAllStudents(@RequestBody Student student){
        return studentService.getAllStudents(student);
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable ("id") Long id,@RequestBody Student student){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable("id") Long id,@RequestBody Student student){
        return studentService.updateStudentById(id,student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable ("id") Long id,@RequestBody Student student) {
        studentService.deleteStudentById(id);
    }

}
