package edu.neu.csye6200.api.helper;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.utils.ConvertUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static edu.neu.csye6200.utils.ConvertUtil.*;

public class StudentHelper {

    public static Student createStudent(ResultSet rs) throws SQLException {
        int c_id, g_id;
        if(rs.getObject("classroom_id") == null){
            c_id = -1;
        }
        else{
            c_id = rs.getInt("classroom_id");
        }
        if(rs.getObject("group_id") == null){
            g_id = -1;
        }
        else{
            g_id = rs.getInt("group_id");
        }

        return new Student(rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("address"),
            ConvertUtil.stringtoLocalDate(rs.getString("date_of_birth")),
            rs.getString("email"),
            rs.getLong("phone_no"),
            rs.getString("parent_name"),
            rs.getInt("student_id"),
            rs.getDate("reg_date"),
            rs.getDouble("rating"),
            c_id, g_id
        );
    }

//    public static Student createStudent(String[] attributes) {
//        LocalDate localDate = stringtoLocalDate(attributes[6]);
//        LocalDate annualDate = localDate.plusYears(1);
//        Student student = new Student();
//        student.setFirstName(attributes[0]);
//        student.setLastName(attributes[1]);
//        student.setAddress(attributes[2]);
//        student.setDateOfBirth(attributes[3]);
//        student.setAge(ConvertUtil.calAge(attributes[3]));
//        student.setParentName(attributes[4]);
//        student.setEmail(attributes[5]);
//        student.setRegistrationDate(attributes[6]);
//        student.setAnnualRegistrationDate(annualDate.toString());
//        student.setPhoneNum(stringToInt(attributes[7]));
//        student.setClassroomId(stringToInt(attributes[8]));
//        student.setGroupId(stringToInt(attributes[9]));
//        student.setReview(stringToDouble(attributes[10]));
//        return student;
//    }
}
