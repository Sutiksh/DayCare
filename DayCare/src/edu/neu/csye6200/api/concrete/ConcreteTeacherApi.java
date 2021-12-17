package edu.neu.csye6200.api.concrete;

import edu.neu.csye6200.api.TeacherApi;
import edu.neu.csye6200.dao.TeacherDao;
import edu.neu.csye6200.model.Teacher;

import java.util.List;

public class ConcreteTeacherApi implements TeacherApi {
    @Override
    public List<Teacher> getAllTeachers() {
        return TeacherDao.getAllTeachersDao();
    }

    @Override
    public int getNumOfTeachers() {
        return TeacherDao.getNumOfTeachersDao();
    }

    @Override
    public List<Teacher> getAllTeachersInClassroom(int classroomId) {
        return TeacherDao.getAllTeachersInClassroomDao(classroomId);
    }

    @Override
    public Teacher getTeacherInGroup(int classroomId, int groupId) {
        return TeacherDao.getTeacherInGroupDao(classroomId, groupId);
    }

    @Override
    public void assignTeacherToGroup(Teacher teacher, int classroomId, int groupId) {
        TeacherDao.assignTeacherToGroupDao(teacher, classroomId, groupId);
        teacher.setClassroom_id(classroomId);
        teacher.setGroup_id(groupId);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        TeacherDao.addTeacherDao(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        TeacherDao.updateTeacherDao(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        TeacherDao.deleteTeacherDao(teacher);
    }

    @Override
    public void deleteTeacher(int teacherId) {
        TeacherDao.deleteTeacherDao(teacherId);
    }

    @Override
    public double getRating(int teacherId) {
        return TeacherDao.getRatingDao(teacherId);
    }
}
