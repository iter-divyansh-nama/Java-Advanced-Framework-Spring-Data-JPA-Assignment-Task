package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.Student;
import com.capgemini.repository.StudentRepository;

@Service
public class StudentService {


@Autowired
private StudentRepository repository;

public void saveStudent(Student student){
    repository.save(student);
}


}
