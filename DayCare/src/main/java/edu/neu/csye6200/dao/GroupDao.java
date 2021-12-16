package edu.neu.csye6200.dao;

import edu.neu.csye6200.model.Group;
import edu.neu.csye6200.model.enums.GroupType;
import edu.neu.csye6200.model.enums.StatusType;
import edu.neu.csye6200.utils.DatabaseUtil;

import java.sql.ResultSet;

public class GroupDao {


    public ResultSet getGroupsByGroupTypeAndStatus(GroupType groupType, StatusType statusType) {
        String sql = "SELECT * FROM group where group_type ='"+groupType+"' and group_status = '"+statusType+"';";
        return DatabaseUtil.getSQLResult(sql);
    }

    public ResultSet getMaxGroupId() {
        String sql = "";
        return DatabaseUtil.getSQLResult(sql);
    }

    public void addGroup(Group group) {
        String sql = "";
        DatabaseUtil.executeSQL(sql);
    }

    public void updateGroup(Group group) {
        String sql = "";
        DatabaseUtil.executeSQL(sql);
    }

    public void deleteGroup(int groupId) {
        String sql = "";
        DatabaseUtil.executeSQL(sql);
    }

    public void deleteGroup(Group group) {
        String sql = "";
        DatabaseUtil.executeSQL(sql);
    }

    public ResultSet getAllGroups() {
        String sql = "";
        return DatabaseUtil.getSQLResult(sql);
    }
}
