package com.capgemini.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.entity.Student;
import com.capgemini.repository.StudentRepository;

@Service
public class StudentService {


@Autowired
private StudentRepository repository;

public Student saveStudent(Student s) {
    return repository.save(s);
}

public List<Student> getAllStudents(){
    return repository.findAll();
}

public Student getStudentById(int id){
    return repository.findById(id).orElse(null);
}

public void deleteStudent(int id){
    repository.deleteById(id);
}


}

