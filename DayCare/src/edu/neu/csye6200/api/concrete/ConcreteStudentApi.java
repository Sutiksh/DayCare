package edu.neu.csye6200.api.concrete;

import edu.neu.csye6200.api.StudentApi;
import edu.neu.csye6200.dao.StudentDao;
import edu.neu.csye6200.model.Student;

import java.util.List;

public class ConcreteStudentApi implements StudentApi {
    @Override
    public int getNumOfStudents() {
        return StudentDao.getNumOfStudentsDao();
    }

    @Override
    public List<Student> getAllStudents() {
        return StudentDao.getAllStudentsDao();
    }

    @Override
    public List<Student> getAllStudentsInClassroom(int classroomId) {
        return StudentDao.getAllStudentsInClassroomDao(classroomId);
    }

    @Override
    public List<Student> getAllStudentsInGroup(int classroomId, int groupId) {
        return StudentDao.getAllStudentsInGroupDao(classroomId, groupId);
    }

    @Override
    public void addStudent(Student student) {
        StudentDao.addStudentDao(student);
    }

    @Override
    public void updateStudent(Student student) {
        StudentDao.updateStudentDao(student);
    }

    @Override
    public void deleteStudent(Student student) {
        StudentDao.deleteStudentDao(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        StudentDao.deleteStudentDao(studentId);
    }
}
