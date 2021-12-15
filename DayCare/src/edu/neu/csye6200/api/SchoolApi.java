package edu.neu.csye6200.api;

import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.enums.ClassroomType;

import java.util.List;

public interface SchoolApi {
    void rateAllTeachers();

    void rateTeacher(int teacherId);

    void assignAllStudentsAndTeachers();

    List<Student> findUnvaccinatedStudentsByImmNameDose(String immName, int dose);

    List<Student> findUnvaccinatedStudents();

    void trackStudentEnrollment();

    void trackStudentRegistration();
}