package com.capgemini.execution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.capgemini.entity.Course;
import com.capgemini.entity.Student;
import com.capgemini.service.StudentService;

@Component
public class TaskManager implements CommandLineRunner{


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

    System.out.println("How many courses?");
    int n = sc.nextInt();
    sc.nextLine();

    List<Course> courseList = new ArrayList<>();

    for(int i=0;i<n;i++){

        System.out.println("Enter Course ID:");
        int cid = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Course Name:");
        String cname = sc.nextLine();

        Course c = new Course();
        c.setCourseId(cid);
        c.setCourseName(cname);

        courseList.add(c);
    }

    Student student = new Student();
    student.setId(id);
    student.setName(name);
    student.setAge(age);
    student.setCourses(courseList);

    service.saveStudent(student);

    System.out.println("Student and Courses saved successfully!");
}


}
