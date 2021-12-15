package edu.neu.csye6200.api;

import edu.neu.csye6200.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentApi {

    int getNumOfStudents();

    List<Student> getAllStudents();

    List<Student> getAllStudentsInClassroom(int classroomId);

    List<Student> getAllStudentsInGroup(int classroomId, int groupId);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);

    void deleteStudent(int studentId);
}