package edu.neu.csye6200.controller;

import edu.neu.csye6200.api.TeacherApi;
import edu.neu.csye6200.api.concrete.ConcreteTeacherApi;
import edu.neu.csye6200.dao.TeacherDao;
import edu.neu.csye6200.model.Teacher;

import java.util.List;

public class TeacherController {
	private final TeacherApi api = new ConcreteTeacherApi();

	public List<Teacher> getAllTeachers() {
		return api.getAllTeachers();
	}

	public int getNumOfTeachers() {
		return api.getNumOfTeachers();
	}

	public List<Teacher> getAllTeachersInClassroom(int classroomId) {
		return api.getAllTeachersInClassroom(classroomId);
	}

	public Teacher getTeacherInGroup(int classroomId, int groupId) {
		return api.getTeacherInGroup(classroomId, groupId);
	}

	public void assignTeacherToGroup(Teacher teacher, int classroomId, int groupId) {
		api.assignTeacherToGroup(teacher, classroomId, groupId);
	}

	public void addTeacher(Teacher teacher) {
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

	public double getRating(int teacherId) {
		return api.getRating(teacherId);
	}

	public void addTeacher(List<Teacher> teachers) {
		api.addTeacher(teachers);
	}
}
