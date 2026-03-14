package com.capgemini.execution;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.capgemini.entity.Address;
import com.capgemini.entity.Student;
import com.capgemini.repository.StudentRepository;

@Component
public class TaskManager implements CommandLineRunner {


@Autowired
private StudentRepository repository;

Scanner sc = new Scanner(System.in);

@Override
public void run(String... args) throws Exception {

    try {

        System.out.println("Enter Address ID:");
        int aid = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter City:");
        String city = sc.nextLine();

        System.out.println("Enter State:");
        String state = sc.nextLine();

        Address address = new Address();
        address.setAddressId(aid);
        address.setCity(city);
        address.setState(state);

        System.out.println("How many students live at this address?");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {

            System.out.println("Enter Student ID:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Student Name:");
            String name = sc.nextLine();

            System.out.println("Enter Student Age:");
            int age = sc.nextInt();
            sc.nextLine();

            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setAge(age);
            student.setAddress(address);

            repository.save(student);
        }

        System.out.println("Students saved successfully!");

    } 
    catch(DataIntegrityViolationException e) {

        System.out.println("❌ Database Error: Duplicate ID or Constraint Violation!");

    } 
    catch(Exception e) {

        System.out.println("❌ Error Occurred: " + e.getMessage());

    }
}


}
