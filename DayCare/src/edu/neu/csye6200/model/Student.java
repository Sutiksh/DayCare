package edu.neu.csye6200.model;

public class Student extends Person {

	private String registrationDate;
	private String annualRegistrationDate;
	private int age;
	private double review;
	private long studentId;

	public Student(String registrationDate, String annualRegistrationDate, int age, double review, long studentId) {
		this.registrationDate = registrationDate;
		this.annualRegistrationDate = annualRegistrationDate;
		this.age = age;
		this.review = review;
		this.studentId = studentId;
	}

	public Student() {    }

	public String getAnnualRegistrationDate() {
		return annualRegistrationDate;
	}

	public void setAnnualRegistrationDate(String annualRegistrationDate) {
		this.annualRegistrationDate = annualRegistrationDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public double getReview() {
		return review;
	}

	public void setReview(double review) {
		this.review = review;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

}