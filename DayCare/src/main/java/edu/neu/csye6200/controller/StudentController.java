package edu.neu.csye6200.controller;

import edu.neu.csye6200.api.StudentApi;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.data.GetAllStudentData;
import edu.neu.csye6200.model.form.AddStudentForm;
import edu.neu.csye6200.model.form.DeleteStudentForm;
import edu.neu.csye6200.model.form.UpdateStudentForm;

public class StudentController {

	public static final StudentApi api = new StudentApi();

	public int getNumOfStudents() {
		return api.getNumOfStudents();
	}

	public GetAllStudentData getAllStudents() {
		return api.getAllStudents();
	}

	public void addStudent(AddStudentForm student) { api.addStudent(student); }

	private void updateStudent(UpdateStudentForm student) {
		api.updateStudent(student);
	}

	public void delStudent(DeleteStudentForm student) {
		api.deleteStudent(student);
	}

	public void delStudent(long studentId) {
		api.deleteStudent(studentId);
	}

	public void setRegistrationDate(String registrationDate, Student student) {
		api.setRegistrationDate(registrationDate, student);
	}

	public String getRegistrationDate(Student student){
		return api.getRegistrationDate(student.getStudentId());
	}

}
