package edu.neu.csye6200.api.helper;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.form.AddStudentForm;
import edu.neu.csye6200.model.form.UpdateStudentForm;
import edu.neu.csye6200.utils.ConvertUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static edu.neu.csye6200.utils.ConvertUtil.*;

public class StudentHelper {

    public static Student convertToStudent(ResultSet rs) {
        Student student = new Student();
        try {
            student.setStudentId(stringToLong(rs.getString("student_id")));
            student.setFirstName(rs.getString("first_name"));
            student.setLastName(rs.getString("last_name"));
            student.setAddress(rs.getString("address"));
            student.setDateOfBirth(rs.getString("date_of_birth"));
            student.setParentName(rs.getString("parent_name"));
            student.setEmail(rs.getString("email"));
            student.setRegistrationDate(rs.getString("reg_date"));
            student.setPhoneNum(stringToInt(rs.getString("phone_no")));
            student.setAge(stringToInt(rs.getString("age")));
            student.setAnnualRegistrationDate(rs.getString("annual_reg_date"));
            student.setReview(stringToDouble(rs.getString("rating")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static Student convertToStudent(String[] attributes) {
        LocalDate localDate = stringtoDate(attributes[6]);
        LocalDate annualDate = localDate.plusYears(1);
        Student student = new Student();
        student.setFirstName(attributes[0]);
        student.setLastName(attributes[1]);
        student.setAddress(attributes[2]);
        student.setDateOfBirth(attributes[3]);
        student.setAge(ConvertUtil.calAge(attributes[3]));
        student.setParentName(attributes[4]);
        student.setEmail(attributes[5]);
        student.setRegistrationDate(attributes[6]);
        student.setAnnualRegistrationDate(annualDate.toString());
        student.setPhoneNum(stringToInt(attributes[7]));
        student.setReview(stringToDouble(attributes[8]));
        return student;
    }

    public static List<Student> convertToStudentList(ResultSet rs) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(convertToStudent(rs));
        return studentList;
    }

    public static Student convertToStudent(AddStudentForm studentForm) {
        Student student = new Student();
        student.setFirstName(studentForm.getFirstName());
        student.setLastName(studentForm.getLastName());
        student.setAddress(studentForm.getAddress());
        student.setEmail(studentForm.getEmail());
        student.setDateOfBirth(studentForm.getDateOfBirth());
        student.setParentName(studentForm.getParentName());
        student.setPhoneNum(studentForm.getPhoneNum());
        student.setRegistrationDate(studentForm.getRegistrationDate());
        student.setReview(studentForm.getReview());
        return student;
    }

    public static Student convertToStudent(UpdateStudentForm studentForm) {
        Student student = new Student();
        student.setFirstName(studentForm.getFirstName());
        student.setLastName(studentForm.getLastName());
        student.setAddress(studentForm.getAddress());
        student.setDateOfBirth(studentForm.getDateOfBirth());
        student.setParentName(studentForm.getParentName());
        student.setReview(studentForm.getReview());
        return student;
    }
}
