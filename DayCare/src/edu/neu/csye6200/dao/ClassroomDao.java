package edu.neu.csye6200.dao;

import edu.neu.csye6200.api.helper.ClassroomHelper;
import edu.neu.csye6200.api.helper.GroupHelper;
import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.Group;
import edu.neu.csye6200.model.enums.ClassroomType;
import edu.neu.csye6200.utils.DatabaseUtil;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDao {
    public static List<Classroom> getAllClassroomsDao() {
        List<Classroom> classroom = new ArrayList<>();
        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM classroom";
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                classroom.add(ClassroomHelper.createClassroom(rs));
            }

            rs.close();
            state.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classroom;
    }

    public static List<Classroom> getAllClassroomsWithTypeDao(ClassroomType classroomType){
        int type = classroomType.ordinal();
        List<Classroom> classroom = new ArrayList<>();

        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM classroom WHERE classroom_type = " + type;
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                classroom.add(ClassroomHelper.createClassroom(rs));
            }

            rs.close();
            state.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classroom;
    }

    public static Classroom getClassroomWithIdDao(int classroom_id) {
        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM classroom WHERE classroom_id = " + classroom_id;
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                return ClassroomHelper.createClassroom(rs);
            }

            rs.close();
            state.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getMaxClassroomIdDao(){
        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT MAX(classroom_id) as max_id FROM classroom";
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("max_id");
            }

            rs.close();
            state.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void clearAll(){
        String sql = "delete from classroom";
        DatabaseUtil.executeSQL(sql);
    }

    public static void addClassroomDao(Classroom classroom) {
        String sql = "insert into classroom (classroom_id, classroom_type, " +
                "student_num, teacher_num, group_num) " +
                "values (" + classroom.getClassroomId() +
                ", " + classroom.getClassroomType().ordinal() +
                ", " + classroom.getNumOfStudent() +
                ", " + classroom.getNumOfTeacher() +
                ", " + classroom.getNumOfGroup() + ");";
        DatabaseUtil.executeSQL(sql);
    }

    public static void updateClassroomDao(Classroom classroom) {
        String sql = "UPDATE classroom SET " +
                "classroom_type = " + classroom.getClassroomType().ordinal() +
                ", student_num = " + classroom.getNumOfStudent() +
                ", teacher_num = " + classroom.getNumOfTeacher() +
                ", group_num = " + classroom.getNumOfGroup() +
                " WHERE classroom_id = " + classroom.getClassroomId();
        DatabaseUtil.executeSQL(sql);
    }

    public static void deleteClassroomDao(Classroom classroom) {
        DatabaseUtil.deleteRecord("classroom", "classroom_id",
                String.valueOf(classroom.getClassroomId()));
    }
}
