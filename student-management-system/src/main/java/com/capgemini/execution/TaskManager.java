package com.capgemini.execution;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.capgemini.entity.Student;
import com.capgemini.service.StudentService;

@Component
public class TaskManager implements CommandLineRunner {


@Autowired
private StudentService service;

Scanner sc = new Scanner(System.in);

@Override
public void run(String... args) throws Exception {

    while(true) {

        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Find Student By ID");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch(choice) {

        case 1:
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            Student s = new Student(id,name,age,course);
            service.saveStudent(s);

            System.out.println("Student Added Successfully!");
            break;

        case 2:
            List<Student> students = service.getAllStudents();
            students.forEach(System.out::println);
            break;

        case 3:
            System.out.print("Enter Student ID: ");
            int sid = sc.nextInt();

            Student student = service.getStudentById(sid);
            System.out.println(student);
            break;

        case 4:
            System.out.print("Enter ID to Delete: ");
            int did = sc.nextInt();

            service.deleteStudent(did);
            System.out.println("Student Deleted!");
            break;

        case 5:
            System.exit(0);

        default:
            System.out.println("Invalid Choice");
        }
    }
}


}
