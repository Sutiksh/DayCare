package edu.neu.csye6200.dao;

import edu.neu.csye6200.api.helper.StudentHelper;
import edu.neu.csye6200.api.helper.TeacherHelper;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    public static List<Teacher> getAllTeachersDao() {
        return null;
    }

    public static int getNumOfTeachersDao() {
        Connection con = DatabaseUtil.getRemoteConnection();
        try {
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT COUNT(*) as num FROM teacher";
            ResultSet rs = state.executeQuery(sql);
            int size = 0;
            if(rs.next()){
                size = rs.getInt("num");
            }
            return size;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static List<Teacher> getAllTeachersInClassroomDao(int classroomId) {
        List<Teacher> teachers = new ArrayList<>();

        Connection con = DatabaseUtil.getRemoteConnection();
        try {
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * as num FROM teacher "
                + "WHERE classroom_id = " + classroomId;
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                teachers.add(TeacherHelper.createTeacher(rs));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teachers;
    }

    public static List<Teacher> getTeacherInGroupDao(int classroomId, int groupId) {
        List<Teacher> teachers = new ArrayList<>();

        Connection con = DatabaseUtil.getRemoteConnection();
        try {
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * as num FROM teacher "
                + "WHERE classroom_id = " + classroomId
                + ", group_id = " + groupId;
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                teachers.add(TeacherHelper.createTeacher(rs));
            }
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
            +"','"+teacher.getTeacherId()
            +"','"+IdToString(teacher.getClassroom_id())
            +"','"+IdToString(teacher.getGroup_id())
            +"','"+teacher.getFirstName()
            +"','"+teacher.getLastName()
            +"','"+teacher.getDateOfBirth()
            +"','"+teacher.getAddress()
            +"','"+teacher.getParentName()
            +"','"+teacher.getPhoneNum()
            +"','"+teacher.getRating()
            + ")";
        DatabaseUtil.executeSQL(sql);
    }

    public static void updateTeacherDao(Teacher teacher) {
        String sql = "UPDATE TEACHER SET "
            + "teacher_id = " + teacher.getTeacherId()
            + ", first_name = " + teacher.getFirstName()
            + ", last_name = " + teacher.getLastName()
            + ", address = " + teacher.getAddress()
            + ", date_of_birth = " + teacher.getDateOfBirth()
            + ", parent_name = " + teacher.getParentName()
            + ", phone_no = " + teacher.getPhoneNum()
            + ", classroom_id = " + IdToString(teacher.getClassroom_id())
            + ", group_id = " + IdToString(teacher.getGroup_id())
            + ", rating = " + teacher.getRating() + "');";
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
        Connection con = DatabaseUtil.getRemoteConnection();
        try {
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT rating FROM teacher WHERE teacher_id = " + teacherId;
            ResultSet rs = state.executeQuery(sql);
            int rating = 0;
            if(rs.next()){
                rating = rs.getInt("rating");
            }
            return rating;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;

    }

    static String IdToString(int id) {
        if (id == -1) {
            return "null";
        } else {
            return String.valueOf(id);
        }
    }
//    public void addTeacher(Teacher teacher) {
//        String sql = "INSERT into TEACHER (classroom_id, group_id, first_name, last_name, date_of_birth, address, email " +
//                "parent_name, phone_no, rating) " +
//                "VALUES('"+teacher.getFirstName()
//                +"','"+teacher.getLastName()
//                +"','"+teacher.getDateOfBirth()
//                +"','"+teacher.getAddress()
//                +"','"+teacher.getEmail()
//                +"','"+teacher.getParentName()
//                +"','"+teacher.getPhoneNum()
//                +"','"+teacher.getRating()+"');";
//        DatabaseUtil.executeSQL(sql);
//    }
//
//    public void updateTeacher(Teacher teacher) {
//        String sql = "UPDATE teacher SET" +
//                "  first_name = '" + teacher.getFirstName() +
//                "', last_name = '" + teacher.getLastName() +
//                "', address = '" + teacher.getAddress() +
//                "', email = '" + teacher.getEmail() +
//                "', parent_name = '" + teacher.getParentName() +
//                "', date_of_birth = '" + teacher.getDateOfBirth() +
//                "', phone_no = '" + teacher.getPhoneNum() +
//                "', rating = '" + teacher.getRating() +
//                " WHERE teacher_id = " + teacher.getTeacherId();
//        DatabaseUtil.executeSQL(sql);
//    }
//
//    public ResultSet getTeacherById(Long teacherId) {
//        String sql = "SELECT * FROM teacher WHERE teacher_id = " + teacherId;
//        return DatabaseUtil.getSQLResult(sql);
//    }
//
//    public ResultSet getTeacherRatingById(long teacherId) {
//        String sql = "SELECT rating FROM teacher WHERE teacher_id = " + teacherId;
//        return DatabaseUtil.getSQLResult(sql);
//    }
//
//    public void deleteTeacherFromDb(Teacher teacher){
//        DatabaseUtil.deleteRecord("teacher", "teacher_id", String.valueOf(teacher.getTeacherId()));
//    }
//
//    public void deleteTeacherFromDb(long teacherId){
//        DatabaseUtil.deleteRecord("teacher", "teacher_id", String.valueOf(teacherId));
//    }
}
