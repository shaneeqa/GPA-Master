package com.gpa.engine.repository;


import com.gpa.engine.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student, String> {
    Student findByRegistrationNumber(String registrationNumber);
}
