package edu.neu.csye6200.model;

import java.time.LocalDate;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String address;
    private LocalDate dateOfBirth;
    private String email;
    private long phoneNum;
    private String parentName;
    private int classroom_id;
    private int group_id;

    protected Person(String firstName, String lastName, String address, LocalDate dateOfBirth, String email,
                     long phoneNum, String parentName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNum = phoneNum;
        this.parentName = parentName;
        // to indicate the person is not assigned
        this.classroom_id = -1;
        this.group_id = -1;
    }

    public Person(String firstName, String lastName, String address, LocalDate dateOfBirth, String email,
                  long phoneNum, String parentName, int classroom_id, int group_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNum = phoneNum;
        this.parentName = parentName;
        this.classroom_id = classroom_id;
        this.group_id = group_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public int getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(int classroom_id) {
        this.classroom_id = classroom_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
}