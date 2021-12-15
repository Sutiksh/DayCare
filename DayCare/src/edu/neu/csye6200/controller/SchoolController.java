package edu.neu.csye6200.controller;

import edu.neu.csye6200.api.SchoolApi;
import edu.neu.csye6200.api.concrete.ConcreteSchoolApi;
import edu.neu.csye6200.model.Student;

import java.util.List;

public class SchoolController {
    private final SchoolApi api = new ConcreteSchoolApi();

    public void rateAllTeachers() {
        api.rateAllTeachers();
    }

    public void rateTeacher(int teacherId) {
        api.rateTeacher(teacherId);
    }

    public void assignAllStudentsAndTeachers() {
        api.assignAllStudentsAndTeachers();
    }

    public List<Student> findUnvaccinatedStudentsByImmNameDose(String immName, int dose) {
        return api.findUnvaccinatedStudentsByImmNameDose(immName, dose);
    }

    public List<Student> findUnvaccinatedStudents() {
        return api.findUnvaccinatedStudents();
    }

    public void trackStudentEnrollment() {
        api.trackStudentEnrollment();
    }

    public void trackStudentRegistration() {
        api.trackStudentRegistration();
    }
}
