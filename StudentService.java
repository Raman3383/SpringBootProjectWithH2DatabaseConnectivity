package com.example.StudentDB.Service;

import com.example.StudentDB.Entity.Student;
import com.example.StudentDB.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Collection<Student> getAllStudents(Student student) {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student updateStudentById(Long id,Student student) {
        Student updatedStudent= studentRepository.findById(id).get();
        updatedStudent.setStudentName(student.getStudentName());
        updatedStudent.setStudentCourse(student.getStudentCourse());
        updatedStudent.setStudentGrades(student.getStudentGrades());
        return studentRepository.save(updatedStudent);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
