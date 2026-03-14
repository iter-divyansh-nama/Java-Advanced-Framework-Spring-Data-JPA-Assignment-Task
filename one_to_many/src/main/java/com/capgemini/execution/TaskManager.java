package com.capgemini.execution;

import java.util.ArrayList;
import java.util.List;
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

    List<Address> addressList = new ArrayList<>();

    System.out.println("How many addresses?");
    int n = sc.nextInt();
    sc.nextLine();

    for(int i=0;i<n;i++) {

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

        addressList.add(address);
    }

    Student student = new Student();
    student.setId(id);
    student.setName(name);
    student.setAge(age);
    student.setAddresses(addressList);

    for(Address a : addressList) {
        a.setStudent(student);
    }

    service.saveStudent(student);

    System.out.println("Student with Addresses saved successfully!");
}


}
