package edu.neu.csye6200.dao;

import edu.neu.csye6200.api.helper.StudentHelper;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.utils.ConvertUtil;
import edu.neu.csye6200.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public static int getNumOfStudentsDao() {
        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT COUNT(*) as num FROM student";
            ResultSet rs = state.executeQuery(sql);
            int stu_size = 0;
            if (rs.next()) {
                stu_size = rs.getInt("num");
            }

            rs.close();
            state.close();
            con.close();
            //System.out.printf("There are %d student", stu_size);
            return stu_size;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getNumOfStudentsInGroup(int classroomId, int groupId) {
        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT COUNT(*) as num FROM student "
                    + "WHERE classroom_id = " + classroomId
                    + " AND group_id = " + groupId;
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("num");
            }

            rs.close();
            state.close();
            con.close();
            //System.out.printf("There are %d student", stu_size);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static List<Student> getAllStudentsDao() {
        List<Student> students = new ArrayList<>();

        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                students.add(StudentHelper.createStudent(rs));
            }

            rs.close();
            state.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static List<Student> getAllStudentsInClassroomDao(int classroomId) {
        List<Student> students = new ArrayList<>();

        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM student WHERE classroom_id = " + classroomId;
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                students.add(StudentHelper.createStudent(rs));
            }

            rs.close();
            state.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static List<Student> getAllStudentsInGroupDao(int classroomId, int groupId) {
        List<Student> students = new ArrayList<>();

        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM student "
                    + "WHERE classroom_id = " + classroomId
                    + ", group_id = " + groupId;
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                students.add(StudentHelper.createStudent(rs));
            }

            rs.close();
            state.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void clearClassroomAndGroup(){
        String sql = "Update student SET " +
                "classroom_id = null, group_id = null;";
        DatabaseUtil.executeSQL(sql);
    }

    public static void addStudentDao(Student student) {
        String sql = "INSERT INTO student (student_id, first_name, "
                + "last_name, address, date_of_birth, parent_name, email, "
                + "reg_date, phone_no, classroom_id, group_id, rating) "
                + "VALUES(" + student.getStudentId()
                + ",'" + student.getFirstName()
                + "','" + student.getLastName()
                + "','" + student.getAddress()
                + "','" + student.getDateOfBirth()
                + "','" + student.getParentName()
                + "','" + student.getEmail()
                + "','" + student.getRegistrationDate()
                + "'," + student.getPhoneNum()
                + ", " + ConvertUtil.idToString(student.getClassroom_id())
                + ", " + ConvertUtil.idToString(student.getGroup_id())
                + " , " + student.getRating() + ");";
        DatabaseUtil.executeSQL(sql);
    }

    public static void updateStudentDao(Student student) {
        String sql = "UPDATE student SET "
                + "first_name = '" + student.getFirstName()
                + "', last_name = '" + student.getLastName()
                + "', address = '" + student.getAddress()
                + "', date_of_birth = '" + student.getDateOfBirth()
                + "', parent_name = '" + student.getParentName()
                + "', email = '" + student.getEmail()
                + "', reg_date = '" + student.getRegistrationDate()
                + "', phone_no = " + student.getPhoneNum()
                + ", classroom_id = " + ConvertUtil.idToString(student.getClassroom_id())
                + ", group_id = " + ConvertUtil.idToString(student.getGroup_id())
                + ", rating = " + student.getRating()
                + " WHERE student_id = " + student.getStudentId();
        DatabaseUtil.executeSQL(sql);
    }

    public static void deleteStudentDao(Student student) {
        DatabaseUtil.deleteRecord("student", "student_id",
                String.valueOf(student.getStudentId()));
    }

    public static void deleteStudentDao(int studentId) {
        DatabaseUtil.deleteRecord("student", "student_id",
                String.valueOf(studentId));
    }
}