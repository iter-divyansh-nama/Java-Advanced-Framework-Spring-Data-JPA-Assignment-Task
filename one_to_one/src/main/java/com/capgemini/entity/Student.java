package com.capgemini.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Student {


@Id
private int id;
private String name;
private int age;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="address_id")
private Address address;

public Student() {}

public Student(int id, String name, int age, Address address) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.address = address;
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

public Address getAddress() {
    return address;
}

public void setAddress(Address address) {
    this.address = address;
}


}
