package edu.neu.csye6200.dao;

import edu.neu.csye6200.api.helper.GroupHelper;
import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.Group;
import edu.neu.csye6200.model.enums.GroupType;
import edu.neu.csye6200.model.enums.StatusType;
import edu.neu.csye6200.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupDao {
    public static int getNumOfGroupsDao() {
        return DatabaseUtil.getTableSize("group");
    }

    public static List<Group> getAllGroupsDao() {
        List<Group> groups = new ArrayList<>();
        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM group1;";
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                groups.add(GroupHelper.createGroup(rs));
            }

            rs.close();
            state.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    public static List<Group> getAllGroupsInClassroomDao(int classroomId) {
        List<Group> groups = new ArrayList<>();
        try {
            Connection con = DatabaseUtil.getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM group1"
                    + "WHERE classroom_id = " + classroomId;
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                groups.add(GroupHelper.createGroup(rs));
            }

            rs.close();
            state.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    public static List<Group> getPartialGroupsByGroupType(GroupType groupType){
        List<Group> groups = getAllGroupsDao();
        int typeIndex = groupType.ordinal();

        List<Group> toDrop = new ArrayList<>();
        for(Group group: groups){
            Classroom temp = ClassroomDao.getClassroomWithIdDao(group.getClassroomId());
            if(temp == null || temp.getClassroomType().ordinal() != typeIndex){
                toDrop.add(group);
            }
            else if(StudentDao.getNumOfStudentsInGroup(group.getClassroomId(), group.getGroupId())
                    >= groupType.getMaxStudentPerGroup()){
                toDrop.add(group);
            }
        }

        groups.removeAll(toDrop);

        return groups;
    }

    public static void clearAll(){
        String sql = "delete from group1";
        DatabaseUtil.executeSQL(sql);
    }

    public static void addGroupDao(Group group) {
        String sql = "INSERT into group1 (group_id, classroom_id, teacher_id) " +
                "VALUES(" + group.getGroupId()
                + ", " + group.getClassroomId()
                + ", " + group.getTeacherId() + ");";
        DatabaseUtil.executeSQL(sql);
    }

    public static void updatedGroupDao(Group group) {
        String sql = "UPDATE group1 SET "
                + "teacher_id = " + group.getTeacherId()
                + " WHERE group_id = " + group.getGroupId()
                + " and classroom_id = " + group.getClassroomId();
        DatabaseUtil.executeSQL(sql);
    }

    public static void delGroupDao(Group group) {
        String sql = "DELETE  FROM  group1 WHERE"
                + "group_id = " + group.getGroupId()
                + " AND classroom_id = " + group.getClassroomId();
        DatabaseUtil.executeSQL(sql);
    }
}
