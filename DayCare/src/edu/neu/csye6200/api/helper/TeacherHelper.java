package edu.neu.csye6200.api.helper;

import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.utils.ConvertUtil;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherHelper {

    public static Teacher createTeacher(ResultSet rs) throws SQLException {
        int c_id, g_id;
        if(rs.getObject("classroom_id") == null){
            c_id = -1;
        }
        else{
            c_id = rs.getInt("classroom_id");
        }
        if(rs.getObject("group_id") == null){
            g_id = -1;
        }
        else{
            g_id = rs.getInt("group_id");
        }

        return new Teacher(rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("address"),
            ConvertUtil.stringtoLocalDate(rs.getString("date_of_birth")),
            rs.getLong("phone_no"),
            rs.getString("parent_name"),
            c_id, g_id,
            rs.getLong("teacher_id")
        );
    }
}
