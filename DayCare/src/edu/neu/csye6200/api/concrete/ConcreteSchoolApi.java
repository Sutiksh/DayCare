package edu.neu.csye6200.api.concrete;

import edu.neu.csye6200.api.SchoolApi;
import edu.neu.csye6200.dao.SchoolDao;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.utils.AutoAssignUtil;

import java.util.List;

public class ConcreteSchoolApi implements SchoolApi {
    @Override
    public void rateAllTeachers() {
        SchoolDao.rateAllTeachersDao();
    }

    @Override
    public void rateTeacher(int teacherId) {
        SchoolDao.rateTeacherDao(teacherId);
    }

    @Override
    public void assignAllStudentsAndTeachers() {
        SchoolDao.assignAllStudentsAndTeachersDao();
    }

    @Override
    public void AddSingleStudentAndAssign(Student student) {
        AutoAssignUtil.groupingLogicForSingleStudent(student);
        AutoAssignUtil.groupingLogicForNewGroups();
    }

    @Override
    public void AddNewStudentsAndAssign(List<Student> students) {
        AutoAssignUtil.groupingLogicForNewStudents(students);
        AutoAssignUtil.groupingLogicForNewGroups();
    }

    @Override
    public List<Student> findUnvaccinatedStudentsByImmNameDose(String immName, int dose) {
        return SchoolDao.findUnvaccinatedStudentsByImmNameDoseDao(immName, dose);
    }

    @Override
    public void trackStudentEnrollment() {
        SchoolDao.trackStudentEnrollmentDao();
    }

    @Override
    public void trackStudentRegistration() {
        SchoolDao.trackStudentRegistrationDao();
    }
}
