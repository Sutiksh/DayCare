package edu.neu.csye6200.model;

import java.sql.Date;
import java.time.LocalDate;

public class Student extends Person {
    private int studentId;
    private Date registrationDate;
    private double rating;

    public Student(String firstName, String lastName, String address, LocalDate dateOfBirth, String email,
                   long phoneNum, String parentName, int studentId, Date registrationDate, double rating,
                   int classroomId, int groupId) {
        super(firstName, lastName, address, dateOfBirth, email, phoneNum, parentName, classroomId, groupId);
        this.studentId = studentId;
        this.registrationDate = registrationDate;
        this.rating = rating;
    }

    public Student(String firstName, String lastName, String address, LocalDate dateOfBirth, String email,
                   long phoneNum, String parentName, int studentId, Date registrationDate) {
        super(firstName, lastName, address, dateOfBirth, email, phoneNum, parentName);
        this.studentId = studentId;
        this.registrationDate = registrationDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}