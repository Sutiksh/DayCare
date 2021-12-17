package edu.neu.csye6200.api;

import edu.neu.csye6200.model.Teacher;

import java.util.List;

public interface TeacherApi {

    List<Teacher> getAllTeachers();

    int getNumOfTeachers();

    List<Teacher> getAllTeachersInClassroom(int classroomId);

    Teacher getTeacherInGroup(int classroomId, int groupId);

    void assignTeacherToGroup(Teacher teacher, int classroomId, int groupId);

    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);

    void deleteTeacher(long teacherId);

    double getRating(int teacherId);

    void addTeacher(List<Teacher> teachers);
}
