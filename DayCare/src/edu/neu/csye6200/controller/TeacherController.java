package edu.neu.csye6200.controller;

import edu.neu.csye6200.api.TeacherApi;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.form.AddTeacherForm;

import java.util.List;

public class TeacherController {

	private final TeacherApi api = new TeacherApi();

	public int getNumOfTeachers() {
		return api.getNumOfTeachers();
	}

	public List<Teacher> getAllTeachers() {
		return api.getAllTeachers();
	}

	public void addTeacher(AddTeacherForm teacher) {
		api.addTeacher(teacher);
	}

	public void updateTeacher(Teacher teacher) {
		api.updateTeacher(teacher);
	}

	public void deleteTeacher(Teacher teacher) {
		api.deleteTeacher(teacher);
	}

	public void deleteTeacher(long teacherId) {
		api.deleteTeacher(teacherId);
	}

	public double getRating(long teacherId) { return api.getRating(teacherId); }
}
