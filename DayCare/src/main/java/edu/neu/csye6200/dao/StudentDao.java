package edu.neu.csye6200.dao;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.utils.DatabaseUtil;

import java.sql.ResultSet;
import java.util.List;

public class StudentDao {

    public void addStudentToDb(Student student){
        String sql = "INSERT INTO student (first_name, last_name, address, date_of_birth, age, parent_name, email, " +
                "reg_date, annual_reg_date, phone_number, review)" +
                "VALUES('" + student.getFirstName()
                + "','" + student.getLastName()
                + "','" + student.getAddress()
                + "','" + student.getDateOfBirth()
                + "','" + student.getAge()
                + "','" + student.getParentName()
                + "','" + student.getEmail()
                + "','" + student.getRegistrationDate()
                + "','" + student.getAnnualRegistrationDate()
                + "','" + student.getPhoneNum()
                + "','" + student.getReview() + "');";
        DatabaseUtil.executeSQL(sql);
    }

    public void updateStudent(Student student){
        String sql = "UPDATE student " + "SET first_name = '" + student.getFirstName()
                + "', last_name = '" + student.getLastName()
                + "', address = '" + student.getAddress()
                + "', date_of_birth = '" + student.getDateOfBirth()
                + "', age = '" + student.getAge()
                + "', parent_name = '" + student.getParentName()
                + "', email = '" + student.getEmail()
                + "', reg_date = '" + student.getRegistrationDate()
                + "', annual_reg_date = '" + student.getAnnualRegistrationDate()
                + "', phone_no = '" + student.getPhoneNum()
                + "', rating = '" + student.getReview()
                + " WHERE student_id = '" + student.getStudentId() + "';";
        DatabaseUtil.executeSQL(sql);
    }

    public ResultSet getStudentFromDb(Student student){
        String sql = "SELECT * FROM student WHERE student_id = "  + student.getStudentId() + ";";
        return DatabaseUtil.getSQLResult(sql);
    }

    public ResultSet getRegDateStudentFromDb(long studentId){
        String sql = "SELECT * FROM student WHERE student_id = " + studentId + ";";
        return DatabaseUtil.getSQLResult(sql);
    }

    public void deleteStudentFromDb(Student student){
        DatabaseUtil.deleteRecord("student", "student_id", String.valueOf(student.getStudentId()));
    }

    public void deleteStudentFromDb(long studentId){
        DatabaseUtil.deleteRecord("student", "student_id", String.valueOf(studentId));
    }

    public ResultSet getStudentsByPhoneNo(List<Long> phoneList) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<phoneList.size(); i++) {
            sb.append(phoneList.get(i));
            if(i<phoneList.size()-1) {
                sb.append(",");
            }
        }
        String sql = "SELECT * FROM student where phone_num in ("+sb+")";
        return DatabaseUtil.getSQLResult(sql);
    }
}
