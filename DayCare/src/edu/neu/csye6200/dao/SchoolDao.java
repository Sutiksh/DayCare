package edu.neu.csye6200.dao;

import edu.neu.csye6200.api.helper.ImmunizationHelper;
import edu.neu.csye6200.api.helper.StudentHelper;
import edu.neu.csye6200.api.helper.TeacherHelper;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.utils.AutoAssignUtil;
import edu.neu.csye6200.utils.DatabaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolDao {
    public static void rateAllTeachersDao() {
        String sql = "UPDATE teacher" +
                "SET teacher.rating = " +
                "(SELECT avg(student.rating) as rating " +
                "FROM student " +
                "INNER JOIN group1 ON student.classroom_id = group1.classroom_id AND student.group_id = group1.group_id " +
                "WHERE student.rating is not null" +
                "GROUP BY group1.teacher_id);";
        DatabaseUtil.executeSQL(sql);
    }

    public static void rateTeacherDao(int teacherId) {
        double avgRate = Double.MIN_VALUE;
        try {
            String sql = "SELECT avg(student.rating) as avg_rate " +
                    "FROM student " +
                    "INNER JOIN group1 ON student.classroom_id = group1.classroom_id AND student.group_id = group1.group_id " +
                    "WHERE group1.teacher_id = 3000004 AND student.rating is not null;";
            ResultSet rs = DatabaseUtil.getSQLResult(sql);
            while (true) {
                assert rs != null;
                if (!rs.next()) break;
                avgRate = rs.getDouble("avg_rate");
            }
            if (avgRate != Double.MIN_VALUE) {
                sql = "UPDATE teacher " +
                        "SET rating = " + avgRate +
                        "WHERE teacher_id = " + teacherId + ";";
                DatabaseUtil.executeSQL(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void assignAllStudentsAndTeachersDao() {
        AutoAssignUtil.groupingLogicForAllStudents();
        AutoAssignUtil.groupingLogicForAllTeachers();
    }

    public static List<Student> findUnvaccinatedStudentsByImmNameDoseDao(String immName, int dose) {
        List<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT immunization.student_id, student.first_name, student.last_name, student.address" +
                    ", student.date_of_birth, student.email, student.phone_no, student.parent_name, " +
                    "student.reg_date, student.rating" +
                    "FROM immunization" +
                    "INNER JOIN student ON immunization.student_id=student.student_id" +
                    "WHERE immunization.imm_name='" + immName + "'" +
                    "    AND immunization.dose_" + dose + "_date is null " +
                    "    AND DATEDIFF(CURDATE(), student.date_of_birth)/30 > " + ImmunizationHelper.getMinMonthByImmNameDose(immName, dose) + ";";
            ResultSet rs = DatabaseUtil.getSQLResult(sql);
            while (true) {
                assert rs != null;
                if (!rs.next()) break;
                students.add(StudentHelper.createStudent(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void trackStudentEnrollmentDao() {

    }

    public static void trackStudentRegistrationDao() {

    }
}
