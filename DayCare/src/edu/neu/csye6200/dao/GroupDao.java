package edu.neu.csye6200.dao;

import edu.neu.csye6200.api.helper.GroupHelper;
import edu.neu.csye6200.model.Group;
import edu.neu.csye6200.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupDao {
    public static List<Group> getAllGroupsDao() {
        List<Group> groups = new ArrayList<>();
        Connection con = DatabaseUtil.getRemoteConnection();
        try {
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM group";
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                groups.add(GroupHelper.createGroup(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    public static List<Group> getAllGroupsInClassroomDao(int classroomId) {
        List<Group> groups = new ArrayList<>();
        Connection con = DatabaseUtil.getRemoteConnection();
        try {
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM group"
                    + "WHERE classroom_id = " + classroomId;
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                groups.add(GroupHelper.createGroup(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    public static void addGroupDao(Group group) {
        String sql = "INSERT into group (group_id, classroom_id, teacher_id) " +
                "VALUES('" + group.getGroupId()
                + "','" + group.getClassroomId()
                + "','" + group.getTeacherId() + "');";
        DatabaseUtil.executeSQL(sql);
    }

    public static void updatedGroupDao(Group group) {
        String sql = "UPDATE group SET "
                + "group_id = " + group.getGroupId()
                + ", classroom_id = " + group.getClassroomId()
                + ", teacher_id = " + group.getTeacherId() + "');";
        DatabaseUtil.executeSQL(sql);
    }

    public static void delGroupDao(Group group) {
        String sql = "DELETE  FROM  group WHERE"
                + "group_id = " + group.getGroupId()
                + "AND classroom_id = " + group.getClassroomId();
        DatabaseUtil.executeSQL(sql);
    }
}
