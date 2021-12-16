package edu.neu.csye6200.dao;

import edu.neu.csye6200.api.helper.TeacherHelper;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.utils.ConvertUtil;
import edu.neu.csye6200.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    public static List<Teacher> getAllTeachersDao() {
        List<Teacher> teachers = new ArrayList<>();

        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM teacher ";
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                teachers.add(TeacherHelper.createTeacher(rs));
            }

            rs.close();
            state.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teachers;
    }

    public static int getNumOfTeachersDao() {
        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT COUNT(*) as num FROM teacher";
            ResultSet rs = state.executeQuery(sql);
            int size = 0;
            if(rs.next()){
                size = rs.getInt("num");
            }

            rs.close();
            state.close();
            con.close();
            return size;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static List<Teacher> getAllTeachersInClassroomDao(int classroomId) {
        List<Teacher> teachers = new ArrayList<>();

        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM teacher "
                + "WHERE classroom_id = " + classroomId;
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                teachers.add(TeacherHelper.createTeacher(rs));
            }

            rs.close();
            state.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teachers;
    }

    public static List<Teacher> getTeacherInGroupDao(int classroomId, int groupId) {
        List<Teacher> teachers = new ArrayList<>();

        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM teacher "
                + "WHERE classroom_id = " + classroomId
                + ", group_id = " + groupId;
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                teachers.add(TeacherHelper.createTeacher(rs));
            }

            rs.close();
            state.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teachers;
    }

    public static void addTeacherDao(Teacher teacher) {
        String sql = "INSERT into TEACHER (teacher_id, classroom_id, group_id, "
            + "first_name, last_name, date_of_birth, "
            + "address, parent_name, phone_no, rating)"
            + "VALUES("
            +teacher.getTeacherId()
            +", "+ ConvertUtil.idToString(teacher.getClassroom_id())
            +", "+ ConvertUtil.idToString(teacher.getGroup_id())
            +",'"+teacher.getFirstName()
            +"','"+teacher.getLastName()
            +"','"+teacher.getDateOfBirth()
            +"','"+teacher.getAddress()
            +"','"+teacher.getParentName()
            +"',"+teacher.getPhoneNum()
            +", "+teacher.getRating()
            + ")";
        DatabaseUtil.executeSQL(sql);
    }

    public static void updateTeacherDao(Teacher teacher) {
        String sql = "UPDATE teacher SET "
            + "first_name = '" + teacher.getFirstName()
            + "', last_name = '" + teacher.getLastName()
            + "', address = '" + teacher.getAddress()
            + "', date_of_birth = '" + teacher.getDateOfBirth()
            + "', parent_name = '" + teacher.getParentName()
            + "', phone_no = " + teacher.getPhoneNum()
            + ", classroom_id = " + ConvertUtil.idToString(teacher.getClassroom_id())
            + ", group_id = " + ConvertUtil.idToString(teacher.getGroup_id())
            + ", rating = " + teacher.getRating()
            +" WHERE teacher_id = " + teacher.getTeacherId();
        DatabaseUtil.executeSQL(sql);
    }

    public static void deleteTeacherDao(Teacher teacher) {
        DatabaseUtil.deleteRecord("teacher", "teacher_id",
            String.valueOf(teacher.getTeacherId()));
    }

    public static void deleteTeacherDao(int teacherId) {
        DatabaseUtil.deleteRecord("teacher", "teacher_id",
            String.valueOf(teacherId));
    }

    public static double getRatingDao(int teacherId) {
        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT rating FROM teacher WHERE teacher_id = " + teacherId;
            ResultSet rs = state.executeQuery(sql);
            int rating = 0;
            if(rs.next()){
                rating = rs.getInt("rating");
            }

            rs.close();
            state.close();
            con.close();
            return rating;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;

    }

}
