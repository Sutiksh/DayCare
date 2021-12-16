package edu.neu.csye6200.model;

public class Teacher extends Person {

	private double rating;
	private long teacherId;

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
}