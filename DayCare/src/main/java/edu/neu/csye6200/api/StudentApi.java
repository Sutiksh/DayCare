package edu.neu.csye6200.api;

import edu.neu.csye6200.api.abstractClass.AbstractStudent;
import edu.neu.csye6200.api.helper.StudentHelper;
import edu.neu.csye6200.dao.StudentDao;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.data.GetAllStudentData;
import edu.neu.csye6200.model.form.AddStudentForm;
import edu.neu.csye6200.model.form.DeleteStudentForm;
import edu.neu.csye6200.model.form.UpdateStudentForm;

import java.sql.ResultSet;
import java.util.List;

public class StudentApi extends AbstractStudent {
    private final StudentDao studentDao = new StudentDao();
    private static final int[] AllMinAge = {6, 13, 25, 36, 48, 60};
    private static final int[] AllMaxAge = {12, 24, 35, 47, 59, Integer.MAX_VALUE};

    @Override
    public int getNumOfStudents() {
        return 0;
    }

    @Override
    public GetAllStudentData getAllStudents() {
        return new GetAllStudentData();
    }

    @Override
    public void addStudent(AddStudentForm studentForm) {
        //Todo Validations required

        //Converting form to Student object
        Student student = StudentHelper.convertToStudent(studentForm);

        // Query the student info from database and cal the age
        addStudent(student);
    }

    @Override
    public void updateStudent(Student student){
        // Get student data if exists from database
        ResultSet rs = studentDao.getStudentFromDb(student);
        // create student object from data
        Student dbStudent = StudentHelper.convertToStudent(rs);

        if(dbStudent.getStudentId()==0){
            // update the data in the database
            studentDao.updateStudent(dbStudent);
        }else{
            // create a new student
            studentDao.addStudentToDb(student);
        }
    }

    public void updateStudent(UpdateStudentForm studentForm){
        //Todo Validations required

        Student student = StudentHelper.convertToStudent(studentForm);

        updateStudent(student);
    }

    @Override
    public void deleteStudent(Student student) {
        // Deleting student using student obj from database
        studentDao.deleteStudentFromDb(student);
    }

    @Override
    public void deleteStudent(long studentId) {
        // Deleting student using student id from database
        studentDao.deleteStudentFromDb(studentId);
    }

    public void setRegistrationDate(String registrationDate, Student student){
        // Setting registration date using student obj
        student.setRegistrationDate(registrationDate);
        // Updating the student object in the database
        updateStudent(student);
    }

    public String getRegistrationDate(long studentId) {
        // Retrieving student data from database
        ResultSet rs = studentDao.getRegDateStudentFromDb(studentId);
        // Creating student from the data
        Student student = null;
        student = StudentHelper.convertToStudent(rs);

        // Returning the registration date
        return student.getRegistrationDate();
    }

    public void addStudent(List<Student> studentList) {
        for(Student student : studentList) {
            addStudent(student);
        }
    }

    public List<Student> getAllStudentByPhoneNo(List<Long> phoneList) {
        ResultSet rs = studentDao.getStudentsByPhoneNo(phoneList);
        return StudentHelper.convertToStudentList(rs);
    }

    public void addStudent(Student student) {
        ResultSet rs = studentDao.getStudentFromDb(student);
        Student studentDB = StudentHelper.convertToStudent(rs);
        if(studentDB.getStudentId()==0) {
            studentDao.addStudentToDb(student);
        } else {
            System.out.println("Record already exists");
        }
    }

    public void deleteStudent(DeleteStudentForm studentForm) {
        deleteStudent(studentForm.getStudentId());
    }
}
