package edu.neu.csye6200.api.helper;

import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.enums.ClassroomType;
import edu.neu.csye6200.model.enums.StatusType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomHelper {
    public static List<Classroom> convertResultSetToGroupList(ResultSet rs, ClassroomType classroomType, StatusType statusType) {
        List<Classroom> classroomList = new ArrayList<>();
        while(true) {
            try {
                if (!rs.next()) break;
                Classroom classroom = new Classroom();
                classroom.setClassroomId(rs.getLong("classroom_id"));
                classroom.setClassroomType(classroomType);
                classroom.setClassroomStatus(statusType);
                classroom.setCurrentGroupCount(rs.getInt("current_group_count"));
                classroom.setMaxGroupPerCount(rs.getInt("max_group_per_count"));
                classroomList.add(classroom);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return classroomList;
    }
}
