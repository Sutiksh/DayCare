package edu.neu.csye6200.api.helper;

import edu.neu.csye6200.model.School;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolHelper {

    public static List<School> convertToSchool(ResultSet rs) {
        List<School> schoolList = new ArrayList<>();
        while(true) {
            try {
                if (!rs.next()) break;
                School school = new School();
                school.setGroupId(rs.getLong("group_id"));
                school.setId(rs.getLong("id"));
                school.setClassroomId(rs.getLong("classroom_id"));
                school.setStudentId(rs.getLong("student_id"));
                school.setTeacherId(rs.getLong("teacher_id"));
                schoolList.add(school);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return schoolList;
    }
}
