package edu.neu.csye6200.model;

import edu.neu.csye6200.utils.ConvertUtil;

import java.util.Date;
import java.time.LocalDate;

public class Student extends Person {
    private long studentId;
    private Date registrationDate;
    private double rating;
    private int monthAge;

    public Student(String firstName, String lastName, String address, LocalDate dateOfBirth, String email,
                   long phoneNum, String parentName, int studentId, Date registrationDate, double rating,
                   int classroomId, int groupId) {
        super(firstName, lastName, address, dateOfBirth, email, phoneNum, parentName, classroomId, groupId);
        this.studentId = studentId;
        this.registrationDate = registrationDate;
        this.rating = rating;
        this.monthAge = ConvertUtil.calAge(dateOfBirth);
    }

    public Student(String firstName, String lastName, String address, LocalDate dateOfBirth, String email,
                   long phoneNum, String parentName, int studentId, Date registrationDate) {
        super(firstName, lastName, address, dateOfBirth, email, phoneNum, parentName);
        this.studentId = studentId;
        this.registrationDate = registrationDate;
        this.monthAge = ConvertUtil.calAge(dateOfBirth);
    }

    public Student(String firstName, String lastName, String email, String address, String parentName, long phoneNumber) {
        super(firstName, lastName, email, address, parentName, phoneNumber);
    }

    public Student(String firstName, String lastName, String email, String address, String parentName, long phoneNumber,
                   LocalDate dateOfBirth, Date registrationDate){
        super(firstName, lastName, address, dateOfBirth, email, phoneNumber, parentName);
        this.registrationDate = registrationDate;
    }

    public Student(long studentId, String firstName, String lastName, String email, String address, String parentName, long phoneNum, LocalDate dob, Date reg_date) {
        super(firstName, lastName, address, dob, email, phoneNum, parentName);
        this.studentId = studentId;
        this.registrationDate = reg_date;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
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

    public int getAge() {
        return monthAge;
    }

    public void setAge(int monthAge) {
        this.monthAge = monthAge;
    }

}