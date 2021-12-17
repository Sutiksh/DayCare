package edu.neu.csye6200.controller;

import edu.neu.csye6200.api.StudentApi;
import edu.neu.csye6200.api.concrete.ConcreteStudentApi;
import edu.neu.csye6200.model.Student;

import java.util.List;

public class StudentController {
	private final StudentApi api = new ConcreteStudentApi();

	public int getNumOfStudents() {
		return api.getNumOfStudents();
	}

	public List<Student> getAllStudents() {
		return api.getAllStudents();
	}

	public List<Student> getAllStudentsInClassroom(int classroomId) {
		return api.getAllStudentsInClassroom(classroomId);
	}

	public List<Student> getAllStudentsInGroup(int classroomId, int groupId) {
		return api.getAllStudentsInGroup(classroomId, groupId);
	}

	public Student getStudentById(long studentId){
		return api.getStudentById(studentId);
	}

	public void addStudent(Student student) {
		api.addStudent(student);
	}

	public void updateStudent(Student student) {
		api.updateStudent(student);
	}

	public void deleteStudent(Student student) {
		api.deleteStudent(student);
	}

	public void deleteStudent(long studentId) {
		api.deleteStudent(studentId);
	}

	public void sendEmail(List<Student> studentList, String vaccineName, int doseNumber){
		api.sendMail(studentList, vaccineName, doseNumber);
	}

	public void sendEmail(Student student){
		api.sendMail(student);
	}

	public void addStudent(List<Student> students) {
		api.addStudent(students);
	}
}
