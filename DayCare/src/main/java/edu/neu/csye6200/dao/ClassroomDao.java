package edu.neu.csye6200.dao;

import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.enums.ClassroomType;
import edu.neu.csye6200.model.enums.StatusType;
import edu.neu.csye6200.utils.DatabaseUtil;

import java.sql.ResultSet;

public class ClassroomDao {


    public ResultSet getGroupsByGroupTypeAndStatus(ClassroomType classroomType, StatusType statusType) {
        String sql = "";
        return DatabaseUtil.getSQLResult(sql);
    }

    public void addClassroom(Classroom classroom) {
        String sql = "";
        DatabaseUtil.executeSQL(sql);
    }

    public ResultSet getMaxClassroomId() {
        String sql = "";
        return DatabaseUtil.getSQLResult(sql);
    }
}
