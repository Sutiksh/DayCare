package edu.neu.csye6200.dao;

import edu.neu.csye6200.model.School;
import edu.neu.csye6200.utils.DatabaseUtil;

import java.sql.ResultSet;

public class SchoolDao {

    public ResultSet getStudentsByGroupId(long groupId) {
        String sql = "SELECT * FROM school where group_id = '"+groupId+"'";
        return DatabaseUtil.getSQLResult(sql);
    }

    public void addSchoolRecord(School school) {
        String sql = "INSERT INTO SCHOOL ";
        DatabaseUtil.executeSQL(sql);
    }
}
