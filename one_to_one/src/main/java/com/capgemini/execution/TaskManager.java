package com.capgemini.execution;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.capgemini.entity.Address;
import com.capgemini.entity.Student;
import com.capgemini.service.StudentService;

@Component
public class TaskManager implements CommandLineRunner {


@Autowired
private StudentService service;

Scanner sc = new Scanner(System.in);

@Override
public void run(String... args) throws Exception {

    System.out.println("Enter Student ID:");
    int id = sc.nextInt();
    sc.nextLine();

    System.out.println("Enter Student Name:");
    String name = sc.nextLine();

    System.out.println("Enter Student Age:");
    int age = sc.nextInt();
    sc.nextLine();

    System.out.println("Enter Address ID:");
    int aid = sc.nextInt();
    sc.nextLine();

    System.out.println("Enter City:");
    String city = sc.nextLine();

    System.out.println("Enter State:");
    String state = sc.nextLine();

    Address address = new Address(aid, city, state);

    Student student = new Student(id, name, age, address);

    service.saveStudent(student);

    System.out.println("Student with Address saved successfully!");
}


}
