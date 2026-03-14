package com.capgemini.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Address {


@Id
private int addressId;
private String city;
private String state;

public Address() {}

public Address(int addressId, String city, String state) {
    this.addressId = addressId;
    this.city = city;
    this.state = state;
}

public int getAddressId() {
    return addressId;
}

public void setAddressId(int addressId) {
    this.addressId = addressId;
}

public String getCity() {
    return city;
}

public void setCity(String city) {
    this.city = city;
}

public String getState() {
    return state;
}

public void setState(String state) {
    this.state = state;
}


}