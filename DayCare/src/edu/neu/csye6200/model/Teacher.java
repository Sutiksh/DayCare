package edu.neu.csye6200.model;

import edu.neu.csye6200.dao.TeacherDao;

import java.time.LocalDate;

public class Teacher extends Person {
	private long teacherId;
	private double rating;

	public Teacher(String firstName, String lastName, String address, LocalDate dateOfBirth, long phoneNum,
				   String parentName, long teacherId) {
		super(firstName, lastName, address, dateOfBirth, null, phoneNum, parentName);
		this.teacherId = teacherId;
	}

	public Teacher(String firstName, String lastName, String address, LocalDate dateOfBirth, long phoneNum,
				   String parentName, int classroom_id, int group_id, long teacherId) {
		super(firstName, lastName, address, dateOfBirth, null, phoneNum, parentName, classroom_id, group_id);
		this.teacherId = teacherId;
	}

    public Teacher(String firstName, String lastName, String address, LocalDate dateOfBirth, String email,  long phoneNumber, String parentName) {
        super(firstName, lastName, address, dateOfBirth, email,  phoneNumber, parentName);
    }

	public double getRating() {
		if(rating > 0){
			return rating;
		}
		else {
			return TeacherDao.getRatingDao(teacherId);
		}
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