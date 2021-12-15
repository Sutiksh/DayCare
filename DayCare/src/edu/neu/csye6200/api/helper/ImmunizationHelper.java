package edu.neu.csye6200.api.helper;

import edu.neu.csye6200.model.Immunization;

import java.sql.ResultSet;
import java.sql.SQLException;

import static edu.neu.csye6200.utils.ConvertUtil.*;

public class ImmunizationHelper {
    public static Immunization createImmunization(ResultSet rs) throws SQLException {
        Immunization imm = new Immunization(
                rs.getString("imm_name"),
                stringToInt(rs.getString("student_id")),
                stringToLong(rs.getString("dose_1_id")),
                stringtoDate(rs.getString("dose_1_date")),
                stringToLong(rs.getString("dose_2_id")),
                stringtoDate(rs.getString("dose_2_date")),
                stringToLong(rs.getString("dose_3_id")),
                stringtoDate(rs.getString("dose_3_date")),
                stringToLong(rs.getString("dose_4_id")),
                stringtoDate(rs.getString("dose_4_date")));
        return imm;
    }
}
