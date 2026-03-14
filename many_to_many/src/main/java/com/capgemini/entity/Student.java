package com.capgemini.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {


@Id
private int id;
private String name;
private int age;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(
    name="student_course",
    joinColumns=@JoinColumn(name="student_id"),
    inverseJoinColumns=@JoinColumn(name="course_id")
)
private List<Course> courses;

public Student(){}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}

public List<Course> getCourses() {
    return courses;
}

public void setCourses(List<Course> courses) {
    this.courses = courses;
}


}
