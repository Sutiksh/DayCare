package edu.neu.csye6200.dao;

import edu.neu.csye6200.api.helper.ImmunizationHelper;
import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImmunizationDao {
    public static List<Immunization> getAllImmunizationDao() {
        List<Immunization> immunizations = new ArrayList<>();
        Connection con = DatabaseUtil.getRemoteConnection();
        try {
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM immunization";
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                immunizations.add(ImmunizationHelper.createImmunization(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return immunizations;
    }

    public static List<Immunization> getImmunizationByNameDao(String immName) {
        List<Immunization> immunizations = new ArrayList<>();
        Connection con = DatabaseUtil.getRemoteConnection();
        try {
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT * FROM immunization"
                    + "WHERE imm_name = " + immName;
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                immunizations.add(ImmunizationHelper.createImmunization(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return immunizations;
    }

    public static void addImmunizationDao(Immunization imm) {
        String sql = "INSERT into immunization (imm_name, student_id, " +
                "dose_1_id, dose_1_date, dose_2_id, dose_2_date" +
                "dose_3_id, dose_3_date, dose_4_id, dose_4_date) " +
                "VALUES('" + imm.getImmunizationName()
                + "','" + imm.getStudentId()
                + "','" + imm.getDoseId1()
                + "','" + imm.getDoseDate1()
                + "','" + imm.getDoseId2()
                + "','" + imm.getDoseDate2()
                + "','" + imm.getDoseId3()
                + "','" + imm.getDoseDate3()
                + "','" + imm.getDoseId4()
                + "','" + imm.getDoseDate4() + "');";
        DatabaseUtil.executeSQL(sql);
    }

    public static void updateImmunizationDao(Immunization imm) {
        String sql = "UPDATE immunization SET "
                + "imm_name = " + imm.getImmunizationName()
                + ", student_id = " + imm.getStudentId()
                + ", dose_1_id = " + imm.getDoseId1()
                + ", dose_1_date = " + imm.getDoseDate1()
                + ", dose_2_id = " + imm.getDoseId2()
                + ", dose_2_date = " + imm.getDoseDate2()
                + ", dose_3_id = " + imm.getDoseId3()
                + ", dose_3_date = " + imm.getDoseDate3()
                + ", dose_4_id = " + imm.getDoseId4()
                + ", dose_4_date = " + imm.getDoseDate4() + "');";
        DatabaseUtil.executeSQL(sql);
    }

    public static void deleteImmunizationDao(Immunization imm) {
        String sql = "DELETE  FROM  group WHERE"
                + "imm_name = " + imm.getImmunizationName()
                + "AND student_id = " + imm.getStudentId();
        DatabaseUtil.executeSQL(sql);
    }
}
