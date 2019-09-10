/*package com.gpa.engine.service;

import com.gpa.engine.repository.StudentRepository;
import com.gpa.engine.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
  *//*  @Autowired
    private StudentRepository studentRepository;*//*

    public Student findByRegistrationNumber(String number) {
        return studentRepository.findByRegistrationNumber(number);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

}*/
