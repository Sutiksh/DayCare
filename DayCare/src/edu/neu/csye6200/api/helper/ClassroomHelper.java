package edu.neu.csye6200.api.helper;

import edu.neu.csye6200.api.factory.ClassroomFactory;
import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.enums.ClassroomType;

import java.sql.ResultSet;
import java.sql.SQLException;

import static edu.neu.csye6200.utils.ConvertUtil.stringToInt;

public class ClassroomHelper {

    static ClassroomFactory factory = ClassroomFactory.getInstance();

    public static Classroom createClassroom(ResultSet rs) throws SQLException {
        ClassroomType type = ClassroomType
                .values()[stringToInt(rs.getString("classroom_type"))];
        return factory.getObject(
            stringToInt(rs.getString("classroom_id")),
            type,
            rs.getInt("student_num"),
            rs.getInt("teacher_num"),
            rs.getInt("group_num")
        );
    }
}
