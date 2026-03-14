package com.capgemini.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {


@Id
private int id;
private String name;
private int age;

@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
private List<Address> addresses;

public Student() {}

public Student(int id, String name, int age, List<Address> addresses) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.addresses = addresses;
}

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

public List<Address> getAddresses() {
    return addresses;
}

public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
}


}
