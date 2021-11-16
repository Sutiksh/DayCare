package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.utils.LocalDate;

public class StudentController {
	private Student model;
	
	StudentController(Student model){
		this.model = model;
	}
	
	public void setImmunizationDate(LocalDate immunizationDate) {
		model.setImmunizationDate(immunizationDate);
	}

	public LocalDate getImmunizationDate() {
		return model.getImmunizationDate();
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		model.setRegistrationDate(registrationDate);
	}

	public LocalDate getRegistrationDate() {
		return model.getRegistrationDate();
	}

	
	public void setGpa(double gpa) {
		model.setGpa(gpa);
	}

	public double getGpa() {
		return model.getGpa();
	}
	
	public void setStudentId(long studentId) {
		model.setStudentId(studentId);
	}

	public long getStudentId() {
		return model.getStudentId();
	}
}