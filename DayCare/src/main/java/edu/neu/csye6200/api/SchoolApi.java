package edu.neu.csye6200.api;

import edu.neu.csye6200.api.helper.SchoolHelper;
import edu.neu.csye6200.dao.SchoolDao;
import edu.neu.csye6200.model.School;

import java.sql.ResultSet;
import java.util.List;

public class SchoolApi {

    private static final SchoolDao schoolDao = new SchoolDao();

    public static List<School> getStudentsInGroup(long groupId) {
        ResultSet rs = schoolDao.getStudentsByGroupId(groupId);
        return SchoolHelper.convertToSchool(rs);
    }

    public static void addSchoolRecord(School school) {
        schoolDao.addSchoolRecord(school);
    }
}
